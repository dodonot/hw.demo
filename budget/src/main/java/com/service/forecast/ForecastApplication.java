package com.service.forecast;

import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableServiceComb
public class ForecastApplication {
	public static void main(final String[] args) throws Exception {
		SpringApplication.run(ForecastApplication.class, args);
	}
}
