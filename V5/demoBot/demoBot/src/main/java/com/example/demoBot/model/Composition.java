package com.example.demoBot.model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="composition_table")
public class Composition {

    @Id
    private String id;
    
    

    private String composition;

}
