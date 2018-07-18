package com.intuit.dao;

public interface StatementDao {
	void addStatement(int accountNumber,String type,int amount);
}
