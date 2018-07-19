package com.intuit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.logic.GuessingGame;

@Controller
public class ProperGameController {
	@Autowired
	private GuessingGame game;

	@PostMapping("/play")
	public String play(@RequestParam int guess, Model model) {
		game.play(guess);
		model.addAttribute("message", game.getMessage());
		model.addAttribute("attempts", "Attempts: " + game.getAttempts());
		if(game.isGameOver())
			return "over";
		return "game";
	}
	
/*
	@PostMapping("/play")
	public String play(@RequestParam int guess, HttpSession session) {
		game.play(guess);
		session.setAttribute("message", game.getMessage());
		session.setAttribute("attempts", "Attempts: " + game.getAttempts());
		if(game.isGameOver())
			return "over";
		return "game";
	}
*/	
	@GetMapping("/game")
	public String index() {
		return "game";
	}

}
