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

    public List<RecommendationDto> getRecommendations(UUID userId) {

        List<RecommendationDto> result = new ArrayList<>();

        // =========================
        // 1. Статические правила
        // =========================
        for (RecommendationRuleSet ruleSet : ruleSets) {
            if (ruleSet.isApplicable(userId.toString())) {
                result.add(ruleSet.getRecommendation());
            }
        }

        // =========================
        // 2. Динамические правила
        // =========================
        result.addAll(dynamicRuleRecommendationService.recommend(userId));

        return result;
    }
}
