package com.example.demoBot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DialogueTest {

    @Test
    void stsrtDialogueTestSrart(){
        Dialogue dialogue = new Dialogue();
        String answer = dialogue.startDialogue("/start");
        Assertions.assertEquals("Это бот пекарни. Он может предоставить меню командой /menu", answer);
    }

    @Test
    void stsrtDialogueTestHelp(){
        Dialogue dialogue = new Dialogue();
        String answer = dialogue.startDialogue("/help");
        Assertions.assertEquals("Это бот пекарни. Он может предоставить меню командой /menu", answer);
    }

    @Test
    void stsrtDialogueTestMenu(){
        Dialogue dialogue = new Dialogue();
        String answer = dialogue.startDialogue("/menu");
        Assertions.assertEquals("Завтраки:\r\n" + //
                        "Круассан с ветчиной и сыром\r\n" + //
                        "Французский тост с кленовым сиропом\r\n" + //
                        "Овсянка на молоке с фруктами\r\n" + //
                        "Пирожные и десерты:\r\n" + //
                        "Шоколадный брауни\r\n" + //
                        "Классический чизкейк\r\n" + //
                        "Тирамису\r\n" + //
                        "Пироги и выпечка:\r\n" + //
                        "Мясной пирог с грибами\r\n" + //
                        "Яблочный пирог с корицей\r\n" + //
                        "Булочки с маком\r\n" + //
                        "Напитки:\r\n" + //
                        "Эспрессо\r\n" + //
                        "Капучино\r\n" + //
                        "Зеленый чай с имбирем\r\n" + //
                        "Сэндвичи и бутерброды:\r\n" + //
                        "Лосось с авокадо на тосте\r\n" + //
                        "Курица с овощами на хлебе с отрубями\r\n" + //
                        "Тунцовый сэндвич с огурцом и майонезом", answer);
    }


}
