package com.intuit.controllers;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
	
	@GetMapping("/guess")
	public String guess() {
		System.out.println("***********");
		return "GuessGame";
	}
	
	@PostMapping("/guessResult")
	public String provess(@RequestParam("number") Integer userInputNumber, HttpSession session) {
		System.out.println("~~~~~~~~~~");
		Integer attemptNumber = setAttemptNumber(session);
		Integer randomNumber = getRandomNumber(session);
		if(randomNumber < userInputNumber) {
			session.setAttribute("message", "AIM Higher! Attempt number is "+attemptNumber);
		}else if(randomNumber > userInputNumber) {
			session.setAttribute("message", "AIM Lower! Attempt number is "+attemptNumber);
		}else {
			session.setAttribute("message", "Congratulations, you win! You got it in "+attemptNumber +" attempts!");
			session.setAttribute("attemptNumber",0);
			session.setAttribute("randomNumber", -1);
		}
		
		return "GuessGame";
	}
	
	public Integer getRandomNumber(HttpSession session) {
		Integer randomNumber = (Integer) session.getAttribute("randomNumber");
		if(null == randomNumber || randomNumber == -1) {
			Random ran = new Random();
			randomNumber = ran.nextInt(100) + 1; 
			session.setAttribute("randomNumber", randomNumber);
			System.out.println("Random selected - "+randomNumber);
		}
		return randomNumber;
	}
	
	public Integer setAttemptNumber(HttpSession session) {
		Integer attemptNumber = (Integer) session.getAttribute("attemptNumber");
		Integer updatedNumber;
		if(null == attemptNumber) {
			updatedNumber = 0;
			session.setAttribute("randomNumber", -1);
		}else {
			updatedNumber = attemptNumber +1;
		}
		session.setAttribute("attemptNumber",updatedNumber);
		return updatedNumber;
	}

}
