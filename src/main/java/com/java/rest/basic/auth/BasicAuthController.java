package com.java.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200", "http://exalted-cogency-302205.el.r.appspot.com", "http://asia.artifacts.exalted-cogency-302205.appspot.com",
		"http://exalted-cogency-302205.appspot.com", "http://staging.exalted-cogency-302205.appspot.com", "http://naveenkumarha.tech", "http://www.naveenkumarha.tech",
		"http://todo-management-naveen-react.herokuapp.com"})
@RestController
public class BasicAuthController {
	@GetMapping(path="/basicauth")
	public AuthenticationBean basicAuth() {
		return new AuthenticationBean("You are authenticated.");
	}
}