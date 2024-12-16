package com.example.demoBot.service;



import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.example.demoBot.config.BotConfig;
import com.example.demoBot.model.AdsRepository;
import com.example.demoBot.model.CompositionRepository;
import com.example.demoBot.model.User;


@Component
@Service
public class TelegramBot extends TelegramLongPollingBot{

    BotConfig config;

        
    @Autowired
    public CompositionRepository compositionRepository;

    @Autowired
    public Dialogue dialogue;


    @Autowired
    private AdsRepository adsRepository;

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

            if (massageText.contains("/send") && chatId == config.getOwnerId()){
                int i = massageText.indexOf(" ");
                if (i != -1){
                    massageText = massageText.substring(i);
                    var users = dialogue.db.userRepository.findAll();
                    for(User user : users){
                        sendMessage(user.getChatId(), massageText);
                    }
                }else{
                    sendMessage(chatId, "Невверный формат ввода! Правильно: /send [текст сообщения]");
                }
            }else if(massageText.equals("/composition")){   

                composition(chatId);

            }else{
                sendMessage(chatId, dialogue.startDialogue(massageText, chatId, config.getOwnerId()));
            }

        } else if (update.hasCallbackQuery()){
            String callBackData = update.getCallbackQuery().getData();
            long messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            EditMessageText message = new EditMessageText();
            message.setChatId(String.valueOf(chatId));
            String text = compositionRepository.findById(callBackData).get().getComposition();
            message.setText(text);
            message.setMessageId((int)messageId);

            try{
                execute(message);
            }
            catch (TelegramApiException e){
                System.out.println("Ошибка sendMessage");
            }


        }

    }

    private void composition(Long chatId){

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Состав какого блюда вы хотите узнать?");

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        AutoKeyboard.autoKeyboard(markupInLine);

        message.setReplyMarkup(markupInLine);

        try{
            execute(message);
        }
        catch (TelegramApiException e){
            System.out.println("Ошибка sendMessage");
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
            System.out.println("Ошибка sendMessage");
        }

    }

    /*@Scheduled(cron = "* * * * * *")
    private void sendAds(){

        var ads = adsRepository.findAll();

        var users = dialogue.db.userRepository.findAll();

        for(Ads ad: ads){
            for (User user : users){
                sendMessage(user.getChatId(), ad.getAd());

            }
        }

    }*/


    @Scheduled(cron = "0 0 9 * * *")
    private void sendAdsMorning(){

        var users = dialogue.db.userRepository.findAll();

        for (User user : users){
            sendMessage(user.getChatId(), "Здравтсвуйте, "+ user.getFirstName() + "! " + adsRepository.findById(1l).get().getAd());
        }
        

    }

    @Scheduled(cron = "0 0 21 * * *")
    private void sendAdsEvening(){

        var users = dialogue.db.userRepository.findAll();

        for (User user : users){
            sendMessage(user.getChatId(), "Здравтсвуйте, "+ user.getFirstName() + "! " + adsRepository.findById(2l).get().getAd());
        }
        

    }


}
