package com.nng.test.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nng.test.dto.Health;

@RestController
public class HealthController {

	private static final Health UP = new Health("UP");

	@RequestMapping("/health")
	public Health getHealth(HttpServletResponse response) {
		Health ret = UP;
		switch (ret.getStatus()) {
		case "UP":
			response.setStatus(HttpStatus.OK.value());
			break;
		case "DOWN":
			response.setStatus(HttpStatus.BAD_REQUEST.value());
			break;
		default:
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			break;
		}
		return ret ;
	}

}
