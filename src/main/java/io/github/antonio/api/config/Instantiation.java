package io.github.antonio.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import io.github.antonio.api.domain.User;
import io.github.antonio.api.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User user1 = new User(null, "Maria Brown", "maria@test.com");
		User user2 = new User(null, "Bob Ancle", "bob@test.com");
		User user3 = new User(null, "Alex Gray", "alex@test.com");
		
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
	}
	
	
	
}
