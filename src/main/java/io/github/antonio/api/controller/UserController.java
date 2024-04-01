package io.github.antonio.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public ResponseEntity<String> store(@RequestBody User user){
		
		User result = service.insert(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(result.getId());
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> destroy(@PathVariable String id){
		service.delete(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> edit(@PathVariable String id, @RequestBody User obj){
		obj.setId(id);
		service.update(obj);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	
}
