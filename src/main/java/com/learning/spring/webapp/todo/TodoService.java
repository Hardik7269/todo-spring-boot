package com.learning.spring.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();;

	static {
		todos.add(new Todo(1, "hardik", "Learn", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(2, "chintan", "Learn AWS", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(3, "hardik", "Learn", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findTodoByName(String username){
		return todos;
	}

}
