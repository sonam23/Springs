package com.intuit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intuit.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("update Account a set a.balance = balance + :p1 where a.accountNumber = :p2")
	@Modifying
	void increaseBalance(@Param("p2") int accountNumber, @Param("p1") int amount);

	@Query("update Account a set a.balance = balance - :p1 where a.accountNumber = :p2")
	@Modifying
	void decreaseBalance(@Param("p2") int accountNumber, @Param("p1") int amount);
}
