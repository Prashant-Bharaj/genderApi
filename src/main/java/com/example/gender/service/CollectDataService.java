package com.example.gender.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.gender.entities.Gender;
import com.example.gender.models.GenderModel;
import com.example.gender.repositories.UsesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CollectDataService {

    @Autowired
    UsesRepository userRepository;

    final String alphabets = "abcdefghijklmnopqrstuvwxyz";

    final java.util.Random rand = new java.util.Random();

    final Set<String> identifiers = new HashSet<String>();

    public String randomName() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(7) + 1;
            for (int i = 0; i < length; i++) {
                builder.append(alphabets.charAt(rand.nextInt(alphabets.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public void collectDataService() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String url = "https://api.genderize.io/?name=";
                Long count = 0L;
                RestTemplate restTemplate = new RestTemplate();
                ObjectMapper objectMapper = new ObjectMapper();
                while (count < Long.MAX_VALUE) {
                    count++;
                    ResponseEntity<String> response = restTemplate.getForEntity(url + randomName(), String.class);
                    GenderModel gender = new GenderModel();
                    try {
                        gender = objectMapper.readValue(response.getBody(), GenderModel.class);
                        if (gender.getGender() == null)
                            continue;
                    } catch (JsonProcessingException e1) {
                        e1.printStackTrace();
                    }
                    userRepository.save(new Gender(gender));
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
