package com.example.demoBot.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Service
public class TelegramBot extends TelegramLongPollingBot{

    BotConfig config;

    @Autowired
    public Dialogue dialogue;


    
    public TelegramBot(BotConfig config){
        this.config = config;
    }

    @Override
    public String getBotUsername(){
        return config.getBotName();
    }

    @Override 
    public String getBotToken(){
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update){

        if (update.hasMessage() && update.getMessage().hasText()){
            String massageText = update.getMessage().getText();

            long chatId = update.getMessage().getChatId();

            //Dialogue dialogue = new Dialogue();

            sendMessage(chatId, dialogue.startDialogue(massageText, chatId));
            //sendMessage(chatId, dialogue.startDialogue(massageText));

        } 

    }


    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try{
            execute(message);
        }
        catch (TelegramApiException e){

        }

    }

}
