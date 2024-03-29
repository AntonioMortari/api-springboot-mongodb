package io.github.antonio.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.github.antonio.api.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
