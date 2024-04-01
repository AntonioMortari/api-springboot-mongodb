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
	
	public void delete(String id) {
		findOne(id);
		repository.deleteById(id);
	}
	
	public void update(User obj) {
		findOne(obj.getId());
		User newObj = new User(obj.getId(), obj.getName(), obj.getEmail());
		updateData(obj, newObj);
		repository.save(newObj);
	}
	
	private void updateData(User obj, User newObj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	
}
