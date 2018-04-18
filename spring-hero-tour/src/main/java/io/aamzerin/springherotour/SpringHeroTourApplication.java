package io.aamzerin.springherotour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringHeroTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHeroTourApplication.class, args);
	}
}
