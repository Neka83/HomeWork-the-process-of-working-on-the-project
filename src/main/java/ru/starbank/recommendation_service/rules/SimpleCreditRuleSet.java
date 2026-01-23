package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class SimpleCreditRuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {
        return true;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "SIMPLE_CREDIT",
                "Simple Credit",
                "Quick credit with minimal documents"
        );
    }
}