package com.danielqueiroz.mongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.danielqueiroz.mongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContains(String text);

	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> findByTitle(String text);

	@Query("{ $and: [ {'date': { $gte: ?1}}, {'date': { $lte: ?2}},{ $or: [{ 'title': { $regex: ?0, $options: 'i'} },{ 'body': { $regex: ?0, $options: 'i'} },{ 'comments.text': { $regex: ?0, $options: 'i'} }] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
