package com.ohnonono.parking.repository;

import com.ohnonono.parking.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
