package com.learning.spring.webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;

	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findTodoByName("hardik");
		model.put("todos", todos);
		return "listTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddNewTodo(ModelMap model) {
		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo( ModelMap model,@Valid Todo todo, BindingResult reasult) {
		
		if (reasult.hasErrors()) {
			return "todo";
		}

		String uasername = (String) model.get("name");
		todoService.addTodo(uasername, todo.getDescription(), todo.getTargetDate(), false);
		// redirect will help -- in redirect add the path of mapping
		return "redirect:todo-list";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo( @RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value= "update-todo" , method = RequestMethod.GET)
	public String showUpdateTodo( @RequestParam int id , ModelMap model) {
		Todo todo = todoService.findById(id); 
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value= "update-todo" , method = RequestMethod.POST)
	public String updateTodo( ModelMap model,@Valid Todo todo, BindingResult reasult) {
		
		if(reasult.hasErrors()) {
			return "todo";
		}
		
		String uasername = (String) model.get("name");
		todoService.updateTodoDetail(todo);
		todo.setUserName(uasername);
		// redirect will help -- in redirect add the path of mapping
		return "redirect:todo-list";
	}
}
