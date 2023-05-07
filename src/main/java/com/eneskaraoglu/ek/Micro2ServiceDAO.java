package com.eneskaraoglu.ek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Micro2ServiceDAO {

	public static void main(String[] args) {
		SpringApplication.run(Micro2ServiceDAO.class, args);
	}

}
