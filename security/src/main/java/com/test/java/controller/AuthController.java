package com.test.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthController {

	@GetMapping(value = "/login")
	public String login(Model model) {

		return "login";
	}
	
	
	@GetMapping(value = "/denied")
	public String denied(Model model) {

		return "denied";
	}
	
}
