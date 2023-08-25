package com.jobi_jobatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobiJobatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobiJobatchApplication.class, args);
	}
}
