package org.example.bowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
	}

	@Bean
	public BowlingGame bowlingGame() {
		return new BowlingGame(); // This is the explicit bean definition
	}

}
