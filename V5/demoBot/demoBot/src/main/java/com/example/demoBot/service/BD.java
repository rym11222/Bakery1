package com.example.demoBot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demoBot.model.User;
import com.example.demoBot.model.UserRepository;




@Component
public class BD {


    @Autowired
    public UserRepository userRepository;

    public boolean checkContentID(Long chatId){
        if (userRepository.findById(chatId).isEmpty())
            return false;
        else
            return true;
    }
    
    public String registerUser(Long chatId, String[] Arr){

        if (!(checkContentID(chatId))){

            

            User user = new User();

            user.setChatId(chatId);
            user.setFirstName(Arr[1]);
            user.setLastName(Arr[2]);
            user.setPhoneNumber(Arr[3]);

            userRepository.save(user);

        }

        return "Регистрация прошла успешно";
    }


}
