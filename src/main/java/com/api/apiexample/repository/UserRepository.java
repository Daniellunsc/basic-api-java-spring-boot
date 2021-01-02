package com.api.apiexample.repository;

import com.api.apiexample.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findFirstByName(String name);
}
