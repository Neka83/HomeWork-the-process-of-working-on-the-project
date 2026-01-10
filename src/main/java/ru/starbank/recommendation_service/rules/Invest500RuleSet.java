package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class Invest500RuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {
        // TODO: логика будет добавлена позже
        return false;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "INVEST_500",
                "Инвестиции от 500 ₽",
                "Инвестируйте от 500 ₽ и начните путь к финансовому росту"
        );
    }
}