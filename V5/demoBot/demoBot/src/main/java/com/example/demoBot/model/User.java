package com.example.demoBot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "test_tabl111")
public class User {

    @Id
    private Long chatId;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public Long getChatId(){
        return chatId;
    }

    public void setChatId(Long chatId){
        this.chatId = chatId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
