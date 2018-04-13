import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from '@rxjs/Observable';
import { of } from 'rxjs/observable/of';

import { MessageService } from './message.service';

import { Hero } from './model/hero';
import { HEROES } from './utils/mock-heroes';

@Injectable()
export class HeroService {

  private getHeroesUrl = 'http://localhost:8080/getHeroes'
  private getHeroeByIdUrl = 'http://localhost:8080/getHero/'

  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }


  private log(message: string) :void{
    this.messageService.add(message);
  }

  getHeroes(): Observable<Hero[]>{
    this.log('HeroService : fetched heroes');
    return this.http.get<Hero[]>(this.getHeroesUrl);
  }

  getHero(id: number): Observable<Hero>{
    this.log(`HeroService : fetched hero id=${id}`);
    return this.http.get<Hero>(this.getHeroeByIdUrl.concat(id));
  }

}
