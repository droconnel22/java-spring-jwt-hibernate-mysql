package com.dennis.oconnell.samplejavaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages={"com.dennis.oconnell.samplejavaapi"})
@EntityScan(basePackages={"com.dennis.oconnell.samplejavaapi"})
@EnableJpaRepositories(basePackages={"com.dennis.oconnell.samplejavaapi"})
@SpringBootApplication
public class TimesheetAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetAPIApplication.class, args);
	}

}

