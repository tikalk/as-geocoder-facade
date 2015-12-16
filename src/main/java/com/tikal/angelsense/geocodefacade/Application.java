package com.tikal.angelsense.geocodefacade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableCaching
//@EnableCircuitBreaker
//@EnableHystrix
//@EnableHystrixDashboard
public class Application {
	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Application.class);

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
