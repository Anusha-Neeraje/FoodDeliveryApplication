package com.example.demo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import antlr.collections.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByEmailAndPassword(String email, String password);

	
}
