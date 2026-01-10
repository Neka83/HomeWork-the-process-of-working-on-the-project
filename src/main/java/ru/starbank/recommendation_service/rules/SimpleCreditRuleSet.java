package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class SimpleCreditRuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {
        return false;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "SIMPLE_CREDIT",
                "Кредит наличными",
                "Оформите кредит — быстрое решение и выгодные условия"
        );
    }
}