package com.danielqueiroz.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.danielqueiroz.mongodb.domain.Post;
import com.danielqueiroz.mongodb.domain.User;
import com.danielqueiroz.mongodb.dto.AuthorDTO;
import com.danielqueiroz.mongodb.repository.PostRepository;
import com.danielqueiroz.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Silva", "mari.s@yahoo.com.br");
		User jose = new User(null, "José Carlos", "carlos_ze@gmail.com");
		User daniel = new User(null, "Daniel Queiroz", "danielqz@gmail.com");

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		simpleDate.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.save(Arrays.asList(maria,jose,daniel));

		Post post1 = new Post(null, simpleDate.parse("21/03/2018"), 
				"Partiu Viajem", "Primeira viagem para São Paulo", new AuthorDTO(maria));
		
		Post post2 = new Post(null, simpleDate.parse("22/03/2018"), 
				"#Cheguei", "Vejo que irei me divertir muito aqui!",new AuthorDTO(maria));
		
		postRepository.save(Arrays.asList(post1,post2));
		
	}

}
