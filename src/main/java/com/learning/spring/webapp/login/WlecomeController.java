package com.learning.spring.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WlecomeController {

	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String goToWlecomePage(ModelMap model) {
		model.put("name", "admin");
		return "wlecome";
	}
}
