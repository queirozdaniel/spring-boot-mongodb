package com.danielqueiroz.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielqueiroz.mongodb.domain.User;
import com.danielqueiroz.mongodb.dto.UserDTO;
import com.danielqueiroz.mongodb.repository.UserRepository;
import com.danielqueiroz.mongodb.service.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll(); 
	}
	
	public User findById(String id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return user;
	}
	
	public User insert(User user) {
		return userRepository.insert(user);
	}

	public void delete(String id) {
		findById(id);
		userRepository.delete(id);
	}
	
	public User update(User user) {
		User newUser = userRepository.findOne(user.getId());
		updateData(newUser, user);
		return userRepository.save(newUser);
		
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
}
