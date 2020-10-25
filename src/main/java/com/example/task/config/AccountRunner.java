package com.example.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.task.model.Account;
import com.example.task.service.AccountService;

@Component
public class AccountRunner implements ApplicationRunner {
	@Autowired
	AccountService accountService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account user = accountService.createAccount("test", "1234");
		System.out.println(user);
	}
}
