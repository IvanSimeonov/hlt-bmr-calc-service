package com.ivnsim.hltbmrcalcservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HltBmrCalcServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HltBmrCalcServiceApplication.class, args);
	}

}
