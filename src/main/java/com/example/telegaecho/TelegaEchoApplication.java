package com.example.telegaecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegaEchoApplication {
    public static void main(String[] args) {

        try {
            String botToken = "6563408491:AAGRIvjmdIL_jqJ7QyEroCGeJQlJiFIo9eE";
            TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication();
            botsApplication.registerBot(botToken, new TelegramService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

