package com.intuit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.intuit.dao.AccountDao;
import com.intuit.dao.StatementDao;

@Service
public class AccountService
{
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private StatementDao statementDao;
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	public void deposit(int accountNumber,String type, int amount) {
		transactionTemplate.execute(new TransactionCallback<Boolean>() {
			public Boolean doInTransaction(TransactionStatus status) {
				try {
					accountDao.deposit(accountNumber, amount);
					statementDao.addStatement(accountNumber, type, amount);
				} catch (Exception e) {
					e.printStackTrace();
					status.setRollbackOnly();
					return false;
				}
				return true;
			}
		});
		
	}
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=MyOwnSillyException.class)
	public void withdraw(int accountNumber,String type, int amount)throws MyOwnSillyException
	{
		accountDao.withdraw(accountNumber, amount);
		String[] arr = {"a","b"};
		//arr[4] = "d";
		if(arr.length < 3)
			throw new MyOwnSillyException();
		statementDao.addStatement(accountNumber, type, amount);
	}
}
