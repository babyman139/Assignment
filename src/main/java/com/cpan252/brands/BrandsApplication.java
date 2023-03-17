package com.cpan252.brands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cpan252.brands.controller.HomeController;


@SpringBootApplication
public class BrandsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BrandsApplication.class, args);
		HomeController controller = context.getBean(HomeController.class);
	}

}
