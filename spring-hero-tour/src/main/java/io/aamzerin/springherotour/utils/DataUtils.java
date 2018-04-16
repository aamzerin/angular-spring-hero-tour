package io.aamzerin.springherotour.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.aamzerin.springherotour.domain.Hero;
import io.aamzerin.springherotour.domain.HeroRepository;

@Service
public class DataUtils {
	
	@Autowired
	HeroRepository heroRepository;
	
	public Integer getNewId(){
		
		List<Hero> heroes = heroRepository.findAll();
		return heroes.get(heroes.size()-1).getId()+1;
	}

}
