package com.java.rest.ws.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins= {"http://localhost:4200", "http://exalted-cogency-302205.el.r.appspot.com", "http://asia.artifacts.exalted-cogency-302205.appspot.com",
		"http://exalted-cogency-302205.appspot.com", "http://staging.exalted-cogency-302205.appspot.com", "http://naveenkumarha.tech", "http://www.naveenkumarha.tech",
		"http://todo-management-naveen-react.herokuapp.com"})
@RestController
public class TodoResource {

	@Autowired
	private TodoHardcodedService service;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return service.getAllTodos();
	}
	
	@DeleteMapping("/users/{username}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long todoId) {
		Todo todo = service.deleteById(todoId);
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return service.findById(id);
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
		Todo todoUpdated = service.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo createdTodo = service.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}