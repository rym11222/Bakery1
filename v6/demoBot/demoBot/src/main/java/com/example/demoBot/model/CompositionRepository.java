package com.example.demoBot.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompositionRepository extends CrudRepository<Composition, String>{

}
