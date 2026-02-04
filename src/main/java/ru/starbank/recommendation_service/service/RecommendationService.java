package ru.starbank.recommendation_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.dto.RecommendationDto;
import ru.starbank.recommendation_service.rules.RecommendationRuleSet;
import ru.starbank.recommendation_service.rules.service.DynamicRuleRecommendationService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final List<RecommendationRuleSet> ruleSets;
    private final DynamicRuleRecommendationService dynamicRuleRecommendationService;

    /**
     * Calculates recommendations using static and dynamic rules.
     */

    public List<RecommendationDto> getRecommendations(UUID userId) {

        List<RecommendationDto> result = new ArrayList<>();


        for (RecommendationRuleSet ruleSet : ruleSets) {
            if (ruleSet.isApplicable(userId.toString())) {
                result.add(ruleSet.getRecommendation());
            }
        }


        result.addAll(dynamicRuleRecommendationService.recommend(userId));

        return result;
    }
}
