package com.example.telegaecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegaEchoApplication {
    public static void main(String[] args) {
        String token = TelegramService.botToken;
        try {
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(token, new TelegramService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

