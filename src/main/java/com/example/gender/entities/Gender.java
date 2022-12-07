package com.example.gender.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.gender.models.GenderModel;

@Entity
public class Gender {
    @Id
    private String name;
    private Integer count;
    private String gender;
    private Double probability;

    public Gender(){};

    public Gender(Integer count, String gender, String name, Double probability) {
        this.count = count;
        this.gender = gender;
        this.name = name;
        this.probability = probability;
    }

    public Gender(GenderModel genderModel) {
        this.count = genderModel.getCount();
        this.gender = genderModel.getGender();
        this.name = genderModel.getName();
        this.probability = genderModel.getProbability();
    }

    public int getCount() {
        return count;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public Double getProbability() {
        return probability;
    }
}
