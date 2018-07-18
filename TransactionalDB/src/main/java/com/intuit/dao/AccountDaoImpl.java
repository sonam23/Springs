package com.intuit.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl extends BaseDaoSupport implements AccountDao {
	public void deposit(int accountNumber, int amount) {
		String sql = "update accounts set balance=balance+"+amount+" where account_number ="+accountNumber;
		getTemplate().update(sql);
	}

	public void withdraw(int accountNumber, int amount) {
		String sql = "update accounts set balance=balance-"+amount+" where account_number ="+accountNumber;
		getTemplate().update(sql);
	}
}
