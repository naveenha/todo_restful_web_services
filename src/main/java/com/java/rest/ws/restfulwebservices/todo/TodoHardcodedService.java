package com.java.rest.ws.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoHardcodedService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static long count = 0;
	static {
		todos.add(new Todo(count++, "User1", "Dancing", new Date(), false));
		todos.add(new Todo(count++, "User1", "Sing", new Date(), false));
		todos.add(new Todo(count++, "User1", "Read", new Date(), false));
	}
	
	public List<Todo> getAllTodos() {
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo == null) return null;
		if(todos.remove(todo)) {
			return todo;
		}
		return null;
	}

	public Todo findById(long id) {
		for(Todo todo:todos) {
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId() == 0) {
			todo.setId(++count);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
}