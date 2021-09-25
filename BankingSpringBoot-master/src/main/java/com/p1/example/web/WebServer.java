package com.p1.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebServer {
	public static final String CUSTOMER_SERVICE_URL = "http://customer-service";

	//public static final String SUBTRACTION_SERVICE_URL = "http://subtraction-service";

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "web-server");
		SpringApplication.run(WebServer.class, args);
	}

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public WebCustomerService CustomerService() {
		return new WebCustomerService(CUSTOMER_SERVICE_URL);
	}

	@Bean
	public BankAppController CustomerController() {
		return new BankAppController(CustomerService());//, subtractionService());
	}

//	@Bean
//	public WebSubtractionService subtractionService() {
//		return new WebSubtractionService(SUBTRACTION_SERVICE_URL);
//	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
