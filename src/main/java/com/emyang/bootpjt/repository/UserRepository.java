package com.emyang.bootpjt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emyang.bootpjt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByName(String name);
	
}
