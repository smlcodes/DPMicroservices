package com.portsmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.portsmanagement.model.Port;

@Repository
public interface PortRepository extends MongoRepository<Port, Long>{

}