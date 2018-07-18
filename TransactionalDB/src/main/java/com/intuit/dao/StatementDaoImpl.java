package com.intuit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class StatementDaoImpl extends BaseDaoSupport implements StatementDao {

	@Override
	public void addStatement(int accountNumber, String type, int amount) {
		String sql = "insert into statements(account_number, amount, type) values (?,?,?)";
		getTemplate().update(sql,accountNumber,amount,type);
	}

}
