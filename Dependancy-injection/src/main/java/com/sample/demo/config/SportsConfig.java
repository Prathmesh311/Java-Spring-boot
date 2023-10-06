package com.sample.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.demo.common.Coach;
import com.sample.demo.common.SwimCoach;

@Configuration
public class SportsConfig {
	
	@Bean
	public Coach swimCoach() {
		return new SwimCoach();
	}

}
