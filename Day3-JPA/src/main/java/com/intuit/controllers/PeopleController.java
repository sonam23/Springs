package com.intuit.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.entity.Persons;
import com.intuit.repository.PersonRepository;

@RestController
public class PeopleController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/save/{name}/{age}")
	public String savePerson(@PathVariable String name, @PathVariable int age) {
		Persons person = new Persons();
		person.setAge(age);
		person.setName(name);
		personRepository.save(person);
		return "Saved";
	}
	
	@GetMapping("/load/{id}")
	public Persons getPerson(@PathVariable int id) {
		Optional<Persons> person = personRepository.findById(id);
		return (person.isPresent())?person.get(): null;
	}
	
	@GetMapping("/all")
	public List<Persons> getAll() {
		return personRepository.findAll();
	}
	
	@GetMapping("/agegreater/{age}")
	public List<Persons> getPersonsWithAgeGreaterTahn(@PathVariable int age){
		return personRepository.getPersonsGreaterThan(age);
	}

}
