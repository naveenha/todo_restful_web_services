package com.java.rest.ws.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins= {"http://localhost:4200", "http://exalted-cogency-302205.el.r.appspot.com", "http://asia.artifacts.exalted-cogency-302205.appspot.com",
		"http://exalted-cogency-302205.appspot.com", "http://staging.exalted-cogency-302205.appspot.com", "http://naveenkumarha.tech", "http://www.naveenkumarha.tech",
		"http://todo-management-naveen-react.herokuapp.com"})
@RestController
public class HelloWorldController {
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Welcome to Todo's Management Application");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Welcome to Todo's Management Application, %s", name));
	}
}