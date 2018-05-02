package io.aamzerin.springherotour.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroUserRepository extends MongoRepository<HeroUser, String>  {
	
	HeroUser findByUsername(String username);

}
