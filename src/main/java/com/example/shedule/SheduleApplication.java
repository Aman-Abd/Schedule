package com.example.shedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class SheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SheduleApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory
				= new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		return restTemplate;
	}
}
