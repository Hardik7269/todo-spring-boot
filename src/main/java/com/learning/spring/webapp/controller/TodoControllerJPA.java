package com.learning.spring.webapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.spring.webapp.Repository.TodoRepository;
import com.learning.spring.webapp.todo.Todo;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJPA {

	public TodoControllerJPA(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	private TodoRepository todoRepository;

	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoRepository.findAll();
		model.put("todos", todos);
		
		return "listTodo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showAddNewTodo(ModelMap model) {
		String userName = getLoggedInUserName(model);
		Todo todo = new Todo(0, userName, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult reasult) {

		if (reasult.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoRepository.deleteById((long) id);
		return "redirect:todo-list";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id, ModelMap model) {
		Todo todo = todoRepository.findById((long) id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult reasult) {

		if (reasult.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUserName(model);
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	private String getLoggedInUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
