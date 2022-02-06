package com.s4u10.calculofrete.apisigabem;
/**
 *
 *  @author s4u10
 *  @since 6/01/2022
 **/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication(scanBasePackages = {"com.s4u10.calculofrete.apisigabem"})
public class ApiSigabemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSigabemApplication.class, args);
	}

}
