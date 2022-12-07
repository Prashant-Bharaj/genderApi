package com.example.gender.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonIgnoreProperties()
public class GenderModel {

    Integer count;
    String gender;
    String name;
    Double probability;
    
    public GenderModel() {
    }
}
