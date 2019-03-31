package com.rest.webservices.restfulwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.User;
import com.rest.webservices.restfulwebservices.dao.UserDAO;
import com.rest.webservices.restfulwebservices.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserDAO userDAO;

	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userDAO.findAll();
	}

	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = userDAO.findById(id);
		if (user == null) {
			throw new UserNotFoundException("UserId " + id + " not found");
		}
		return user;
	}

	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		userDAO.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id) {
		User user = userDAO.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("UserId " + id + " not found");
		}
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
}
