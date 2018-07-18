package com.intuit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intuit.dao.Persons;
import com.intuit.entity.PersonsTable;

public class ApplicationStartup {
	
	public static void main(String args[]) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans.xml");
		Persons person = context.getBean("persons", Persons.class);
		
		person.delete(3);
		
		for(PersonsTable p:  person.getAllPeopleData()) {
			System.out.println(p.getId()+", "+p.getName()+", "+p.getAge());
		}
	}

}
