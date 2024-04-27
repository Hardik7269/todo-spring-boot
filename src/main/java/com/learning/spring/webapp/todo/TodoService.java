package com.learning.spring.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList<>();;

	static {
		todos.add(new Todo(++todoCount, "hardik", "Learn", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "chintan", "Learn AWS", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "hardik", "Learn", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findTodoByName(String username){
		return todos;
	}
	
	public void addTodo(String username, String descripiton , LocalDate date , boolean isDone) {
		++todoCount;
		Todo newTodo = new Todo(todoCount , username, descripiton , date , false);
		todos.add(newTodo);
	}

}
