package com.nng.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nng.test.dto.User;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
		UserMemoryDb.addUsers(
				new User(1, "Test 01"),
				new User(2, "Test 02"),
				new User(3, "Test 03")
		);
	}
}
