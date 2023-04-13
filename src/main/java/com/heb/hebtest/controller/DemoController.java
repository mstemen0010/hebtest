package com.heb.hebtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

// Class
public class DemoController {

	@GetMapping("/")
	public String index() {

		// Print statement
		return "Hello World from Spring Boot...!";
	}
}
