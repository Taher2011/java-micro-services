package com.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.webservices.restfulwebservices.bean.StaticBean;

@RestController
public class StaticFilterController {

	@GetMapping("/static")
	public StaticBean retrieveBean() {
		return new StaticBean("value1", "value2", "value3");
	}

	@GetMapping("/static-list")
	public List<StaticBean> retrieveBeansOfList() {
		return Arrays.asList(new StaticBean("tali20", "java", "2222"), new StaticBean("amishra", "java", "value32"));
	}

}
