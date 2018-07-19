package com.intuit.logic;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GuessingGame {
	private int target;
	private int attempts;
	private String message;
	private boolean gameOver;
	public GuessingGame() {
		target = (int)(Math.random() * 100);
	}
	
	public void play(int guess) {
		attempts++;
		if(guess > target)
			message = "Aim Lower";
		else if(guess < target)
			message = "Aim Higher";
		else {
			message = "You've got it in " + attempts + " attempts";
			gameOver = true;
		}
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public int getAttempts() {
		return attempts;
	}
	public String getMessage() {
		return message;
	}
	
}
