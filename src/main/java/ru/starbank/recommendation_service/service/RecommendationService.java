package ru.starbank.recommendation_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.dto.RecommendationDto;
import ru.starbank.recommendation_service.rules.service.DynamicRuleRecommendationService;
import ru.starbank.recommendation_service.rules.RecommendationRuleSet;

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

        // 1️⃣ Статические правила
        for (RecommendationRuleSet ruleSet : ruleSets) {
            if (ruleSet.isApplicable(userId.toString())) {
                result.add(ruleSet.getRecommendation());
            }
        }

        // 2️⃣ Динамические правила (из БД)
        List<String> dynamicProducts =
                dynamicRuleRecommendationService.getRecommendations(userId);

        for (String productName : dynamicProducts) {
            result.add(
                    new RecommendationDto(
                            productName,
                            productName,
                            "Dynamic rule recommendation"
                    )
            );
        }

        return result;
    }
}