package com.danielqueiroz.mongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielqueiroz.mongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User daniel = new User("1", "Daniel", "daniel@gmail.com");
		User alex = new User("2", "Alex", "alex@gmail.com");
		
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(daniel,alex));
		
		return ResponseEntity.ok().body(lista);
	}
	
}
