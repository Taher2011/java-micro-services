package com.rest.webservices.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rest.webservices.restfulwebservices.bean.DynamicBean;

@RestController
public class DynamicFilterController {

	@GetMapping("/dynamic")
	public MappingJacksonValue retrieveBean() {
		DynamicBean dynamicBean = new DynamicBean("tali20", "wma", "1234");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName", "dept");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(dynamicBean);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping("/dynamic-list")
	public MappingJacksonValue retrieveBeansOfList() {
		List<DynamicBean> list = Arrays.asList(new DynamicBean("tali20", "java", "2222"),
				new DynamicBean("amishra", "cobol", "value32"));
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("dept");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}

}
