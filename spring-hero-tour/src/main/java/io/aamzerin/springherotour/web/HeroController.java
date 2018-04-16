package io.aamzerin.springherotour.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.aamzerin.springherotour.domain.Hero;
import io.aamzerin.springherotour.domain.HeroRepository;
import io.aamzerin.springherotour.utils.DataUtils;

@RestController
public class HeroController {

	@Autowired
	HeroRepository heroRepository;

	@Autowired
	DataUtils dataUtils;

	@GetMapping("getHeroes")
	public List<Hero> getHeroes() {
		System.out.println("getHeroes called");
		return heroRepository.findAll();
	}

	@GetMapping("getHero/{id}")
	public Hero getHero(@PathVariable(value = "id") Integer id) {
		System.out.println("getHero called, id : " + id);
		return heroRepository.findById(id);
	}

	@PostMapping("addHero")
	public Hero addHero(@RequestBody Hero hero) {
		System.out.println("addHero called, id : " + hero);
		if (hero.getId() == null)
			hero.setId(dataUtils.getNewId());
		return heroRepository.save(hero);
	}

	@DeleteMapping("deleteHero/{id}")
	public Long deleteHero(@PathVariable(value = "id") Integer id) {
		System.out.println("deleteHero called, id : " + id);
		return heroRepository.deleteById(id);
	}
}
