package com.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VehicleInsuranceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(VehicleInsuranceApplication.class, args);

		ConfigurableApplicationContext ap = SpringApplication.run(VehicleInsuranceApplication.class, args);
	}

}
