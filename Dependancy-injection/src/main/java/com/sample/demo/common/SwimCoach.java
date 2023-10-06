package com.sample.demo.common;

public class SwimCoach implements Coach{
	
	public SwimCoach() {
		System.out.println("In Constructor: " + getClass().getSimpleName());
	}
	
	public String getDailyWorkout() {
		return "Swim for 1000m in one go!";
	}

}
