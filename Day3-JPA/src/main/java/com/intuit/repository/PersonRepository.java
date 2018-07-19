package com.intuit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.intuit.entity.Persons;

@Repository
public interface PersonRepository extends JpaRepository<Persons, Integer>{
	
	@Query("select p from Persons p where p.age > :p1")
	public List<Persons> getPersonsGreaterThan(@Param("p1")int age);

}
