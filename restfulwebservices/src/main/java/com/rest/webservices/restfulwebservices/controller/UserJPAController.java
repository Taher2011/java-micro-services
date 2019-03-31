package com.rest.webservices.restfulwebservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.Post;
import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.dao.PostJPARepository;
import com.rest.webservices.restfulwebservices.dao.UserJPARepository;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserJPAController {

	@Autowired
	private UserJPARepository userJPARepository;
	
	@Autowired
	private PostJPARepository postJPARepository;

	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userJPARepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public Optional<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userJPARepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("UserId " + id + " not found");
		}
		return user;
	}

	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		userJPARepository.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/jpa/users")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userJPARepository.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userJPARepository.deleteById(id);
	}

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrieveUserAndPosts(@PathVariable int id) {
		Optional<User> user = userJPARepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("UserId " + id + " not found");
		}
		return user.get().getPosts();
	}

	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<User> createPostForUser(@PathVariable int id, @RequestBody Post post) {
		Optional<User> user = userJPARepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("UserId " + id + " not found");
		}

		User userDB = user.get();
		
		post.setUser(userDB);
		
		postJPARepository.save(post);

		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
}
