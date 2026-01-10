package ru.starbank.recommendation_service.rules;

import org.springframework.stereotype.Component;
import ru.starbank.recommendation_service.dto.RecommendationDto;

@Component
public class TopSavingRuleSet implements RecommendationRuleSet {

    @Override
    public boolean isApplicable(String userId) {
        // TODO: SQL-логика будет позже
        return false;
    }

    @Override
    public RecommendationDto getRecommendation() {
        return new RecommendationDto(
                "59efc529-2fff-41af-baff-90ccd7402925",
                "Top Saving",
                "Откройте свою собственную «Копилку» с нашим банком!"
        );
    }
}