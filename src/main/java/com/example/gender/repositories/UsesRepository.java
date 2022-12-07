package com.example.gender.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gender.entities.Gender;

public interface UsesRepository extends JpaRepository<Gender, String> {
    
}
