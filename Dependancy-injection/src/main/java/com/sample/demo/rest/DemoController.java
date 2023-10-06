package com.sample.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.common.Coach;

@RestController
public class DemoController {
	
	//Define private field for dependancy
	private Coach myCoach;
	
	//Define constructor for dependacy injection
	@Autowired
	public DemoController(@Qualifier("swimCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
	
	@GetMapping("/getWorkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	

}
