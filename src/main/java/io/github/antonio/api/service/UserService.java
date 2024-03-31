package io.github.antonio.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.antonio.api.domain.User;
import io.github.antonio.api.repository.UserRepository;
import io.github.antonio.api.service.exception.NotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public Optional<User> findOne(String id) {
	    Optional<User> result = repository.findById(id);
	    
	    if (result.isEmpty()) {
	        throw new NotFoundException("Usuário não encontrado");
	    }
	    
	    return result;
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}

	
}
