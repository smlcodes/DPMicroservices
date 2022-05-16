package com.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.usermanagement.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long>{

}