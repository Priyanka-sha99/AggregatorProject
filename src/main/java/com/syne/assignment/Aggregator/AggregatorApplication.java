package com.syne.assignment.Aggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.syne.assignment.Aggregator.entity.AggregatorPlan;

@SpringBootApplication
public class AggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}
	
	 @Bean
	 public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	 
	 @Bean
	 public AggregatorPlan getAggregatorPlan() {
	      return new AggregatorPlan();
	   }

}
