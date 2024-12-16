package com.example.demoBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demoBot.model.CompositionRepository;

//import org.springframework.stereotype.Component;

@Component
public class Dialogue {


    @Autowired
    public BD db;

    public String startDialogue(String massage, Long chatId, Long ownerId){

        

        String ownerMsg = new String("\nВведите команту /send для отправки сообщения всмем пользователям");

        

        String [] Arr = massage.split(" ");
        switch (Arr[0]) {
            case ("/start"):
                if(chatId.equals(ownerId)){
                    return Bakery.help() + ownerMsg;
                }else{
                    return Bakery.help();
                }
            case ("/help"):
                if(chatId.equals(ownerId)){
                    return Bakery.help() + ownerMsg;
                }else{
                    return Bakery.help();
                }
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
