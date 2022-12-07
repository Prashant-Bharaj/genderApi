package com.example.gender.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gender.entities.Gender;
import com.example.gender.repositories.UsesRepository;
import com.example.gender.service.CollectDataService;

@RestController
public class GenderController {

    @Autowired
    UsesRepository userRepository;

    @GetMapping("/")
    public String welcome(){
        return "you can you findbyname and findall";
    }
    
    @GetMapping("/findbyname")
    public Optional<Gender> findById(@RequestParam String name){
        return userRepository.findById(name);
    }

    @GetMapping("/findall")
    public List<Gender> findAll(){
        return userRepository.findAll();
    }

}
