package org.fooddelivery.onlinefood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Online Food Delivery Application",version="1.0",description="An API used for Online Food Delivery Implementation."))
public class OnlinefoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlinefoodApplication.class, args);
	}

}
