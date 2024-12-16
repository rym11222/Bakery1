package com.example.demoBot.service;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class AutoKeyboard {

    public static InlineKeyboardMarkup autoKeyboard(InlineKeyboardMarkup markupInLine){
        String [] menu = ("Круассан с ветчиной и сыром\r\n" + //
                        "Французский тост с кленовым сиропом\r\n" + //
                        "Овсянка на молоке с фруктами\r\n" + //
                        "Шоколадный брауни\r\n" + //
                        "Классический чизкейк\r\n" + //
                        "Тирамису\r\n" + //
                        "Мясной пирог с грибами\r\n" + //
                        "Яблочный пирог с корицей\r\n" + //
                        "Булочки с маком\r\n" + //
                        "Эспрессо\r\n" + //
                        "Капучино\r\n" + //
                        "Зеленый чай с имбирем\r\n" + //
                        "Лосось с авокадо на тосте\r\n" + //
                        "Курица с овощами на хлебе с отрубями\r\n" + //
                        "Тунцовый сэндвич с огурцом и майонезом").split("\r\n");

        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        for (String i : menu){
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            var button = new InlineKeyboardButton();
            button.setText(i);
            button.setCallbackData(i.substring(0, 2).toUpperCase());
            rowInLine.add(button);
            rowsInLine.add(rowInLine);
        }
        markupInLine.setKeyboard(rowsInLine);

        return markupInLine;

    }

}
