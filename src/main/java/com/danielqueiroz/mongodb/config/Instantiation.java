package com.danielqueiroz.mongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielqueiroz.mongodb.domain.User;
import com.danielqueiroz.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "mari.s@yahoo.com.br");
		User jose = new User(null, "José Carlos", "carlos_ze@gmail.com");
		User daniel = new User(null, "Daniel Queiroz", "danielqz@gmail.com");
		
		userRepository.save(Arrays.asList(maria,jose,daniel));
	}

}
