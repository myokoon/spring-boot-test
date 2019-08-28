package com.emyang.bootpjt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emyang.bootpjt.entity.User;
import com.emyang.bootpjt.exception.ResourceNotFoundException;
import com.emyang.bootpjt.repository.UserRepository;

@RestController
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}
	
	@PutMapping("/users/{id}")
	public User update(@PathVariable Long id, @RequestBody User userDetail) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		user.setName(userDetail.getName());
		user.setEmail(userDetail.getEmail());
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
	
}
