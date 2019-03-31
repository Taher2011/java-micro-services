package com.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.versioning.Name;
import com.rest.webservices.restfulwebservices.versioning.PersonV1;
import com.rest.webservices.restfulwebservices.versioning.PersonV2;

@RestController
public class PersonVersioningController {

	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Taher");
	}

	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Taher", "Ali"));
	}

	@GetMapping(value = "/person/param", params = "Version=1")
	public PersonV1 param1() {
		return new PersonV1("Taher");
	}
	
	@GetMapping(value = "/person/param", params = "Version=2")
	public PersonV2 param2() {
		return new PersonV2(new Name("Taher", "Ali"));
	}
}
