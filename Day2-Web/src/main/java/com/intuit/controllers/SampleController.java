package com.intuit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	
	@GetMapping("/greet")
	@ResponseBody
	public String greet() {
		return "Good Morning World!";
	}
	
	@GetMapping("/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable("name") String name) {
		return "Hello "+name+"!";
	}
	
	@PostMapping
	@ResponseBody
	public String echo(@RequestParam("name") String name) {
		return "Calling out to "+name+"!!";
	}

}
