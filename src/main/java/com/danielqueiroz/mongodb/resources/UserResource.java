package com.danielqueiroz.mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielqueiroz.mongodb.domain.User;
import com.danielqueiroz.mongodb.dto.UserDTO;
import com.danielqueiroz.mongodb.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> lista = service.findAll();

		List<UserDTO> listaDto = lista.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDto);
	}

}
