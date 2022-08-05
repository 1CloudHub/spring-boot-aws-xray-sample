package com.anthunt.aws.spring.boot.xray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.anthunt.aws.spring.boot.xray.service.TestService;

@RestController
@XRayEnabled
@RequestMapping("/")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("todo")
	public String index() {
		
		testService.test();
		
		return "SUCCESS: 20 Seconds wait time. Open X-Ray to see the result";
	}
	
	@RequestMapping("/")
	public String health() {			
		return "HEALTH OK. Hit /todo to access TODO API";
	}
	
}
