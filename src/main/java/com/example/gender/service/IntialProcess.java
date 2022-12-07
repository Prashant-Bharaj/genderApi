package com.example.gender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class IntialProcess implements CommandLineRunner {

    @Autowired
    CollectDataService collectDataService;

    @Override
    public void run(String... args) throws Exception {
        collectDataService.collectDataService();
    }
}
