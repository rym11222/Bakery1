package com.example.demoBot.service;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demoBot.model.User;
import com.example.demoBot.model.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
public class BD {

    private static final Logger logger = LoggerFactory.getLogger(BD.class);

    @Autowired
    public UserRepository userRepository;

    public boolean checkContentID(Long chatId){
        if (userRepository.findById(chatId).isEmpty())
            return false;
        else
            return true;
    }
    
    public boolean registerUser(Long chatId, String[] Arr){

        if (checkContentID(chatId)){
            return false;
        }
        
        User user = new User();
        user.setChatId(chatId);
        user.setFirstName(Arr[1]);
        user.setLastName(Arr[2]);
        user.setPhoneNumber(Arr[3]);
        userRepository.save(user);
        return true;
    }
}
