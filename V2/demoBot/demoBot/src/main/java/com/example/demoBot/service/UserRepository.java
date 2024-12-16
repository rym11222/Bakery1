package com.example.demoBot.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;

@Component
//@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
