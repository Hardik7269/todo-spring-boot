package com.learning.spring.webapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	private TodoService todoService ;

	@RequestMapping("/todo-list")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findTodoByName("hardik");
		model.put("todos", todos);
		return "listTodo";
	}
}
