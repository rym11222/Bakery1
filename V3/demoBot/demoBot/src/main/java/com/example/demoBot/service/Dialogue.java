package com.example.demoBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import org.springframework.stereotype.Component;

@Component
public class Dialogue {

    @Autowired
    public BD db;

    public String startDialogue(String massage, Long chatId){

        

        

        String [] Arr = massage.split(" ");
        switch (Arr[0]) {
            case ("/start"):
                return Bakery.help();
            case ("/help"):
                return Bakery.help();
            case ("/menu"):
                return Bakery.menu();
            case("/register"):
                if (Arr.length < 4){
                    return "Невверный формат ввода! Правильно: /register [Имя] [Фамилия] [Номер телефона]";
                }
                
                return db.registerUser(chatId, Arr);
        
            default:
                return "not recognized";
        }
    }

}
