package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class TopSavingRuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {
        return true;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "TOP_SAVING",
                "Top Saving",
                "Best saving account with high interest"
        );
    }
}