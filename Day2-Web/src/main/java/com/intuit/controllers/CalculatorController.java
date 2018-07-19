package com.intuit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.logic.Calculate;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
	
	@Autowired
	Calculate calculator;
	
	@Autowired
	private List<String> calcops;
	
	@GetMapping
	public List<String> getOperation(){
		return calcops;
	}
	
	@GetMapping(path="/add/{value1}/{value2}")
	@ResponseBody
	public String add(@PathVariable int value1, @PathVariable int value2) {
		return "Added Value1="+value1+ " Value2="+value2+ " Total="+calculator.add(value1, value2);
	}
	
	@GetMapping(path="/square/{value1}")
	@ResponseBody
	public String square(@PathVariable int value1) {
		return "Square of Value1="+value1+ " is="+calculator.square(value1);
	}
	
	@GetMapping(path="/subtract/{value1}/{value2}")
	@ResponseBody
	public String subtract(@PathVariable int value1, @PathVariable int value2) {
		return "Subtract Value1="+value1+ " Value2="+value2+ " Total="+calculator.subtract(value1, value2);
	}
	
	@PostMapping(path="/product")
	@ResponseBody
	public String product(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
		return "Product Value1="+value1+ " Value2="+value2+ " Total="+calculator.product(value1, value2);
	}

}
