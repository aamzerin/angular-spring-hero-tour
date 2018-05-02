package io.aamzerin.springherotour.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.aamzerin.springherotour.domain.HeroUser;
import io.aamzerin.springherotour.domain.HeroUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private HeroUserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/sign-up")
	public void signUp(@RequestBody HeroUser user){
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

}
