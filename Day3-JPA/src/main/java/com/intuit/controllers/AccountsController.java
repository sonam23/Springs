package com.intuit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.entity.Statement;
import com.intuit.service.AccountService;

@RestController
@RequestMapping("/bank")
public class AccountsController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/statements/{accountNumber}")
	public List<Statement> printStatement(@PathVariable int accountNumber){
		return accountService.getStatementsFor(accountNumber);
	}
	
	@PostMapping("/deposit/{accountNumber}/{amount}")
	public String deposit(@PathVariable int accountNumber,@PathVariable int amount) {
		accountService.deposit(accountNumber, amount, "Deposit");
		return "Deposit success";
	}
	@PostMapping("/withdraw/{accountNumber}/{amount}")
	public String withdraw(@PathVariable int accountNumber,@PathVariable int amount) {
		accountService.withdraw(accountNumber, amount, "Withdraw");
		return "Withdraw success";
	}
}