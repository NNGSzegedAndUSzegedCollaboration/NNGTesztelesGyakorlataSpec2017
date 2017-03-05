package com.nng.test.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nng.test.dto.Health;

@RestController
public class HealthController {

	private static final Health UP = new Health("UP");
	private static final Health DOWN = new Health("DOWN");

	@RequestMapping("/health")
	public Health getHealth(HttpServletResponse response) {
		Health ret = new Date().getTime() % 2 == 0 ? UP : DOWN;
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
