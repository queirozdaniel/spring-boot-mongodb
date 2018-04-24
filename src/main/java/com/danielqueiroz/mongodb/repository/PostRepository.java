package com.danielqueiroz.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.danielqueiroz.mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
