package com.intuit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.entity.Account;
import com.intuit.entity.Statement;
import com.intuit.repository.AccountRepository;
import com.intuit.repository.StatementRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StatementRepository statementRepository;

	public List<Statement> getStatementsFor(int accountNumber) {
		return statementRepository.findAllByAccountNumber(accountNumber);
	}

	@Transactional
	public void deposit(int accountNumber, int amount, String type) {

		// IF THE ACCOUNTNUMBER IS NOT PRESENT, NEW STATEMENT STILLS GETS INSERTED
		accountRepository.increaseBalance(accountNumber, amount);
		insertStatement(accountNumber, amount, type);

//		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
//		if(accountOptional.isPresent()) {
//			Account account = accountOptional.get();
//			account.setBalance(account.getBalance() + amount);
//			accountRepository.save(account);
//			insertStatement(accountNumber, amount, type);
//		}
	}

	@Transactional
	public void withdraw(int accountNumber, int amount, String type) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if (accountOptional.isPresent()) {
			Account account = accountOptional.get();
			account.setBalance(account.getBalance() - amount);
			accountRepository.save(account);
			insertStatement(accountNumber, amount, type);
		}
	}

	private void insertStatement(int accountNumber, int amount, String type) {
		Statement statement = new Statement();
		statement.setAccountNumber(accountNumber);
		statement.setAmount(amount);
		statement.setType(type);
		statementRepository.save(statement);
	}

}