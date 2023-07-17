package com.codeconnect.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeconnect.model.MyBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/staticfilter")
	public MyBean getBean1() {
		MyBean bean=new MyBean("feild1", "feild2", "feild3");
	
		return bean;
	}
	
	@GetMapping("/dynamicfilter")
	public MappingJacksonValue getBean2() {
		MyBean bean=new MyBean("feild1", "feild2", "feild3");
		MappingJacksonValue mappingJackson=new MappingJacksonValue(bean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
		
		FilterProvider filters= new SimpleFilterProvider().addFilter("myfilter", filter);
		
		mappingJackson.setFilters(filters);
		
		
		return mappingJackson;
	}
	
}
