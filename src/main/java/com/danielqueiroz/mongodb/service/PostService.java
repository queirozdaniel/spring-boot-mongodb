package com.danielqueiroz.mongodb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielqueiroz.mongodb.domain.Post;
import com.danielqueiroz.mongodb.repository.PostRepository;
import com.danielqueiroz.mongodb.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Post post = postRepository.findOne(id);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}

		return post;
	}

	public List<Post> findByTitle(String text){
		return postRepository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate =  new Date(maxDate.getTime() + 24 * 60 *60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}
