package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class Invest500RuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {

        return true;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "INVEST_500",
                "Invest 500",
                "Investment starting from 500"
        );
    }
}