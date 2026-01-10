package ru.starbank.recommendation_service.rules;

import ru.starbank.recommendation_service.dto.RecommendationDto;

import java.util.Optional;

public interface RecommendationRuleSet {

    boolean isApplicable(String userId);

    RecommendationDto getRecommendation();
}