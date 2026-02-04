package ru.starbank.recommendation_service.rules;

import ru.starbank.recommendation_service.dto.RecommendationDto;

public interface RecommendationRuleSet {

    boolean isApplicable(String userId);

    RecommendationDto getRecommendation();
}