package io.aamzerin.springherotour.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import io.aamzerin.springherotour.domain.Hero;
import io.aamzerin.springherotour.domain.HeroRepository;

@Configuration
class DataInitializr implements ApplicationRunner{
	
	@Autowired
	HeroRepository repository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Hero(null,11,"Mr. Nice"));
		repository.save(new Hero(null,12,"Narco"));
		repository.save(new Hero(null,13,"Bombasto"));
		repository.save(new Hero(null,14,"Celeritas"));
		repository.save(new Hero(null,15,"Magneta"));
		repository.save(new Hero(null,16,"RubberMan"));
		repository.save(new Hero(null,17,"Dynama"));
		repository.save(new Hero(null,18,"Dr IQ"));
		repository.save(new Hero(null,19,"Magma"));
		repository.save(new Hero(null,20,"Tornado"));

		// fetch all customers
		System.out.println("Heroes found with findAll():");
		System.out.println("-------------------------------");
		
		repository.findAll().stream().forEach(hero -> System.out.println(hero));

	}

}