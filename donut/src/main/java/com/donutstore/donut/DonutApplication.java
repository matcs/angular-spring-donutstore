package com.donutstore.donut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.donutstore.Controller"})
@EntityScan(basePackages = {"com.donutstore.Model"})
@EnableJpaRepositories("com.donutstore.Repository")
@SpringBootApplication
public class DonutApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonutApplication.class, args);
	}

}
