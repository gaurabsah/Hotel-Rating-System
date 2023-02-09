package com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
