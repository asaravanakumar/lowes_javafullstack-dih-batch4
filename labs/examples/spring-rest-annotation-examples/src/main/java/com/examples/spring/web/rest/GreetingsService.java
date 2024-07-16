package com.examples.spring.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsService {

	//GET http://localhost:8080/spring-rest-annotation-examples/
	//GET http://localhost:8080/spring-rest-annotation-examples/greetings

	@RequestMapping(value = { "/", "/greetings" }, method = RequestMethod.GET)
	public String greeting() {
		return "Welcome to RESTful services training :)";
	}

	//GET http://localhost:8080/spring-rest-annotation-examples/greetings?msg=HelloRest
	@RequestMapping(value = "/greetings", method = RequestMethod.GET, params = { "msg" })
	public String getGreeting(@RequestParam( required = false, defaultValue = "Hello") String msg) {
		return "Welcome to RESTful services training :) - " + msg ;
	}

	//GET http://localhost:8080/spring-rest-annotation-examples/greetings/100
	@RequestMapping(value = "/greetings/{id}", method = RequestMethod.GET)
	public String getGreetingWithPathVariable(@PathVariable String id) {
		return "Welcome to RESTful services training :) - " + id;
	}

	//POST http://localhost:8080/spring-rest-annotation-examples/greetings

	@RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "text/plain" })
	public @ResponseBody String postGreetingMap(@RequestBody String greeting) {
		return "Welcome to RESTful services training :) - " + greeting;
	}

	//POST http://localhost:8080/spring-rest-annotation-examples/greetings

	@RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "application/json", "application/xml"},
	produces = {"application/json", "application/xml"} )
	public Greetings postGreetingObject(@RequestBody Greetings greeting) {
		greeting.setMessage(greeting.getMessage() + " - POST object mapping example");
		return greeting;
	}

	//POST http://localhost:8080/spring-rest-annotation-examples/greetings/collection

	@RequestMapping(value = "/greetings/collection", method = RequestMethod.POST)
	public Map<String, Object> postGreetingMap(@RequestBody Map<String, Object> greeting) {
		greeting.put("updated", "POST collection mapping example");
		return greeting;
	}

	//POST http://localhost:8080/spring-rest-examples/greetings/entity

	@RequestMapping(value = "/greetings/entity", method = RequestMethod.POST)
	public ResponseEntity<Greetings> postGreetingEntity(@RequestBody Greetings greeting) throws URISyntaxException {
		greeting.setMessage(greeting.getMessage() + " Updated");

		HttpHeaders resHeaders = new HttpHeaders();
		resHeaders.add("message", "POST entity mapping example");

		//ResponseEntity<Greetings> res = new ResponseEntity<Greetings>(greeting, resHeaders, HttpStatus.CREATED);

		URI uri = new URI("http://localhost:8080/spring-rest-annotation-examples/greetings/entity/1");

		return ResponseEntity.created(uri).body(greeting);
//		return res;
	}

	//PUT http://localhost:8080/spring-rest-examples/greetings/100

	@RequestMapping(value = "/greetings/{messageId}", method = RequestMethod.PUT)
	public Greetings putGreetingWithPathVariable(@RequestBody Greetings greeting,
														   @PathVariable String messageId) {
		greeting.setMessage("PUT collection mapping with path variable example - " + messageId);
		return greeting;
	}

	//http://localhost:8080/spring-rest-examples/greetings/matrix/100;msgType=INFO

	@RequestMapping(value = "/greetings/matrix/{messageId}", method = RequestMethod.PUT)
	public Greetings putGreetingWithMatrixParameters(@RequestBody Greetings greeting,
													 @MatrixVariable("msgType") String msgType) {
		greeting.setMessage("Message Type is " + msgType) ;
		return greeting;
	}
}
