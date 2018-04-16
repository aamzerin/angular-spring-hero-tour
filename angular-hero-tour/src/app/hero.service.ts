import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from '@rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { catchError, map, tap, retry } from 'rxjs/operators';

import { MessageService } from './message.service';

import { Hero } from './model/hero';
import { HEROES } from './utils/mock-heroes';

@Injectable()
export class HeroService {

  const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  private getHeroesUrl = 'http://localhost:8085/getHeroes';
  private getHeroByIdUrl = 'http://localhost:8085/getHero/';
  private addHeroUrl = 'http://localhost:8085/addHero';
  private deleteHeroByIdUrl = 'http://localhost:8085/deleteHero/';

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }


  private log(message: string) :void{
    this.messageService.add(message);
  }

  getHeroes(): Observable<Hero[]>{
    this.log('HeroService : fetched heroes');
    return this.http.get<Hero[]>(this.getHeroesUrl).pipe(
      tap(heroes=>this.log('fetched heroes'))
      catchError(this.handleError)
    );
  }

  getHero(id: number): Observable<Hero>{
    this.log(`HeroService : fetched hero id=${id}`);
    return this.http.get<Hero>(this.getHeroByIdUrl.concat(id))
    .pipe(
      tap(_=> this.log(`fetched hero id=${id}`)),
      catchError(this.handleError)
    );
  }

  updateHero(hero: Hero): void{
    this.log(`HeroService : updated hero name=${hero.getname}`);
    return this.http.post<Hero>(this.addHeroUrl, hero, this.httpOptions)
    .pipe(
      tap(_=> this.log(`updated hero id=${hero.id}`)),
      catchError(this.handleError)
    );
  }

  addHero(hero: Hero): Observable<Hero>{
    this.log(`HeroService : added hero name=${hero.getname}`);
    return this.http.post<Hero>(this.addHeroUrl, hero, this.httpOptions)
    .pipe(
      tap(_=> this.log(`updated hero id=${hero.id}`)),
      catchError(this.handleError)
    );
  }

  deleteHero(hero: Hero|number): Observable<Hero>{

    const id = typeof hero === 'number' ? hero : hero.id;

    this.log(`HeroService : delete hero id=${id}`);
    return this.http.delete<Hero>(this.deleteHeroByIdUrl.concat(id), this.httpOptions)
    .pipe(
      tap(_=> this.log(`updated hero id=${id}`)),
      catchError(this.handleError)
    );
  }

}
