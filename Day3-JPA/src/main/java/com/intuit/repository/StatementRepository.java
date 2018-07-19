package com.intuit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intuit.entity.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement,Integer> {

	@Query("select s from Statement s where s.accountNumber = :p1")
	List<Statement> findAllByAccountNumber(@Param("p1") int accountNumber);

}