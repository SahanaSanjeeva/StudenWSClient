package com.wsresclient.server.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.wsresclient.beans.StudentRegistration;
import com.wsresclient.beans.StudentRegistrationReply;
import com.wsresclient.beans.Welcome;

@SpringBootApplication
public class WsClientApplication {

	private static final Logger log = LoggerFactory.getLogger(WsClientApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(WsClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			StudentRegistration registration = new StudentRegistration();
			registration.setAge(35);
			registration.setName("Sahana");
			Welcome welc = restTemplate.getForObject("http://localhost:8083/welcome/user?name=Sahana", Welcome.class);
			StudentRegistrationReply resp = restTemplate.postForObject("http://localhost:8083/register/student", registration, StudentRegistrationReply.class);
			log.info(welc.getMessage());
			log.info(resp.getRegistrationNumber());
			log.info(resp.getRegistrationStatus());
		};
	}
}
