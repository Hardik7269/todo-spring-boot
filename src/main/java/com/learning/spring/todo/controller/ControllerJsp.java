package com.learning.spring.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerJsp {
	
	@RequestMapping("hello")
	@ResponseBody
	public String response() {
		return "Heyy Mic testing";
	}
	
	@RequestMapping("/jsp")
	public String responseJSP() {
		return "sayHello";
	}
}
