package com.micro.microservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.micro.microservice.entity.UserDetails;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<UserDetails, Long>{

	Optional<UserDetails> findByEmailAndPassword(String email, String password);
}
