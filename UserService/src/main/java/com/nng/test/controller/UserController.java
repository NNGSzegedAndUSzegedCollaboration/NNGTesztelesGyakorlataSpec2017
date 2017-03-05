package com.nng.test.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nng.test.ConvertServiceConfig;
import com.nng.test.UserMemoryDb;
import com.nng.test.dto.User;
import com.nng.test.exception.AddUserException;
import com.nng.test.exception.GetUserException;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	protected ConvertServiceConfig config;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected ObjectMapper objectMapper;

	private static final ParameterizedTypeReference<String> RESPONSE_TYPE = new ParameterizedTypeReference<String>() {
	};

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestParam("userId") Integer userId) throws GetUserException {
		try {
			return new ResponseEntity<>(UserMemoryDb.getUser(userId), HttpStatus.OK);
		} catch (Exception ex) {
			throw new GetUserException();
		}
	}
	
	@RequestMapping(value = "/latestId", method = RequestMethod.GET)
	public Integer getLatestId() {
		return UserMemoryDb.getMaxId();
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user) throws AddUserException {
		try {
			ResponseEntity<String> name = restTemplate.exchange(config.getConvertServiceConvertEndpoint(),
					HttpMethod.GET, null, RESPONSE_TYPE, user.getUsername());
			user = objectMapper.readValue(name.getBody(), User.class);
			user.setUserId(UserMemoryDb.getMaxId() + 1);
			UserMemoryDb.addUsers(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (IOException e) {
			throw new AddUserException();
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@RequestParam("userId") Integer userId) {
		User user = UserMemoryDb.getUser(userId);
		UserMemoryDb.removeUser(user);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
