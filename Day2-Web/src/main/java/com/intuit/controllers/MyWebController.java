package com.intuit.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyWebController {

	@GetMapping("/index")
	public String getIndex() {
		return "MyView";
		
	}
	
	@PostMapping("/processForm")
	public String provess(@RequestParam("firstname") String firstName, HttpSession session) {
		String msg = "Hi "+firstName;
		session.setAttribute("message", msg);
		return "Result";
	}
}
