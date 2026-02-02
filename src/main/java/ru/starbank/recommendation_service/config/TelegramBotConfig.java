package ru.starbank.recommendation_service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import jakarta.annotation.PostConstruct;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class TelegramBotConfig {

    private final List<LongPollingBot> bots;

    @PostConstruct
    public void registerBots() throws Exception {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        for (LongPollingBot bot : bots) {
            api.registerBot(bot);
        }
    }
}
