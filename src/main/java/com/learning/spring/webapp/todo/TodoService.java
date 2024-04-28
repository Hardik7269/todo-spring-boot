package com.learning.spring.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList<Todo>();;

	static {
		todos.add(new Todo(++todoCount, "Hardik", "Learn Gamming ", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "Hardik", "Learn AWS Certified", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "Hardik", "Learn Spring Boot", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findTodoByName(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUserName().equals(username);
		return todos.stream().filter(predicate).toList();
//		return todos; 
	}
	
	public void addTodo(String username, String descripiton , LocalDate date , boolean isDone) {
		++todoCount;
		Todo newTodo = new Todo(todoCount , username, descripiton , date , false);
		todos.add(newTodo);
	}
	
	public void deleteTodo(int id) {
		//predicate Functional programming
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate); 
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}


	public void updateTodoDetail(@Valid Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}

}
