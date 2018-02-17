package com.iqmsoft.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.iqmsoft.demo.domain.Client;
import com.iqmsoft.demo.domain.Employee;

@SpringBootApplication
public class AopProxyInterceptApp implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AopProxyInterceptApp.class);

	@Autowired
	private Employee person;
	
	@Autowired
	private Client customer;

	public static void main(String[] args) {
		SpringApplication.run(AopProxyInterceptApp.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		String msg = this.person.sayHello();
		LOGGER.info(msg);
		
		String echo = this.customer.echo("Client Hello through Interceptor");
		LOGGER.info(echo);
		
		String echo1 = this.customer.print("Print Client Hello through Interceptor");
		LOGGER.info(echo1);
	}
	
	
}
