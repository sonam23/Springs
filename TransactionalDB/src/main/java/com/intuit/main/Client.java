package com.intuit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.intuit.service.AccountService;
import com.intuit.service.MyOwnSillyException;

public class Client {
		
		public static void main(String args[]) throws MyOwnSillyException {
			ApplicationContext context = new FileSystemXmlApplicationContext("classpath:beans3.xml");
			AccountService service = context.getBean("accountService",AccountService.class);
			service.deposit(1, "Deposit", 2000);
			service.withdraw(1, "Withdraw", 500);
		//	System.out.println(service.getClass().getName());
		//	System.out.println(service.getClass().getSuperclass().getName());
			System.out.println("Done");
		}

}
