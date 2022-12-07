package com.example.gender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.example.gender.service.CollectDataService;

@SpringBootApplication
@EnableCaching
public class GenderApplication {
	public static void main(String[] args) {
		SpringApplication.run(GenderApplication.class, args);
	}
}
