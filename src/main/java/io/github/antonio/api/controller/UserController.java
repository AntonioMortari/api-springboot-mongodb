package io.github.antonio.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.antonio.api.domain.User;
import io.github.antonio.api.dto.UserDTO;
import io.github.antonio.api.service.UserService;
import io.github.antonio.api.service.exception.NotFoundException;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> index(){
		List<User> result = service.findAll();
		List<UserDTO> listDTO = result.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> show(@PathVariable String id) {
	    Optional<User> result = service.findOne(id);
	    
	    if (result.isEmpty()) {
	        throw new NotFoundException("Usuário não encontrado");
	    }
	    
	    return ResponseEntity.ok().body(new UserDTO(result.get()));
	}

	
}
