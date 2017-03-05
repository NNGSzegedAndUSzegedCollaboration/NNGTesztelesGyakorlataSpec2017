package com.nng.test.controller;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nng.test.dto.User;
import com.nng.test.exception.GetUserException;
import com.nng.test.exception.WrongUserNameException;

@RestController
@RequestMapping("/convert")
public class ConvertController {

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public User checkName(@RequestParam("username") String username) throws GetUserException {
		try {
//			return UserMemoryDb.getUser(userId);
			return null;
		} catch (Exception ex) {
			throw new GetUserException();
		}
	}
	
	@RequestMapping(value = "/convert", method = RequestMethod.GET)
	public User convertName(@RequestParam("username") String userName) throws WrongUserNameException {
		
		if(userName.matches("\\d+")) {
			throw new WrongUserNameException();
		}
		String[] array = userName.split(" ");
		userName = String.join(" ", Arrays.stream(array)
				.map(x -> String.valueOf(x.charAt(0)).toUpperCase() + x.substring(1))
				.collect(Collectors.toList()));
		User user = new User(userName);
		return user;
	}

}
