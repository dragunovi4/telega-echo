package com.example.telegaecho;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

@Service
public class TelegramService implements LongPollingSingleThreadUpdateConsumer {
    static String botToken = "6563408491:AAGRIvjmdIL_jqJ7QyEroCGeJQlJiFIo9eE";
    TelegramClient telegramClient = new OkHttpTelegramClient(botToken);

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String messageText = update.getMessage().getText();

            String upperCaseMessage = messageText.toUpperCase();

            SendMessage sendMessage = new SendMessage(chatId, upperCaseMessage);
            try {
                telegramClient.execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}