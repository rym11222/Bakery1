package com.example.demoBot.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.Data;

@Configuration
@ComponentScan(basePackages = {"com.example.demoBot.model"})
@EnableScheduling
@Data
@PropertySource("application.properties")
public class BotConfig {

    @Value("${bot.name}")
    String botName;

    @Value("${bot.key}")
    String token;
}
