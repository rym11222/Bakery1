package com.example.demoBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="adsTable")
public class Ads {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    

    private String ad;

}
