package com.learning.spring.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login" , method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping(value="login" , method = RequestMethod.POST)
	public String goToWlecomePage(@RequestParam String name , @RequestParam String password, ModelMap model) {

		if(authenticationService.Authenticate(name , password)) {
			model.put("name", name);
			model.put("password", password);
			return "wlecome";
		}
		model.put("Error", "Invalid Credentials. Try Again");	
		return "login";
	}
}
