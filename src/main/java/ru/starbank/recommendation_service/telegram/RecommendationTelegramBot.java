package ru.starbank.recommendation_service.telegram;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.starbank.recommendation_service.service.RecommendationService;
import ru.starbank.recommendation_service.user.entity.UserEntity;
import ru.starbank.recommendation_service.user.service.UserService;

@Component
@RequiredArgsConstructor
public class RecommendationTelegramBot extends TelegramLongPollingBot {

    private final RecommendationService recommendationService;
    private final UserService userService;
    private final TelegramProperties properties;

    @Override
    public void onUpdateReceived(Update update) {

        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        String text = update.getMessage().getText().trim();
        Long chatId = update.getMessage().getChatId();

        if (!text.startsWith("/recommend")) {
            send(chatId,
                    """
                    Привет!
                    Доступна команда:
                    /recommend <username>
                    """
            );
            return;
        }

        String[] parts = text.split(" ");

        if (parts.length != 2) {
            send(chatId, "Используй: /recommend <username>");
            return;
        }

        String username = parts[1];

        UserEntity user = userService.findByUsername(username);

        if (user == null) {
            send(chatId, "Пользователь не найден");
            return;
        }

        var recommendations =
                recommendationService.getRecommendations(user.getUuid());

        if (recommendations.isEmpty()) {
            send(chatId, "Пользователь не найден");
            return;
        }

        StringBuilder response = new StringBuilder();
        response.append("Здравствуйте ")
                .append(user.getFirstName())
                .append(" ")
                .append(user.getLastName())
                .append("\n\n");
        response.append("Новые продукты для вас:\n");

        recommendations.forEach(r ->
                response.append("• ")
                        .append(r.getName())
                        .append(" — ")
                        .append(r.getText())
                        .append("\n")
        );

        send(chatId, response.toString());
    }

    private void send(Long chatId, String text) {
        try {
            execute(new SendMessage(chatId.toString(), text));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }
}
