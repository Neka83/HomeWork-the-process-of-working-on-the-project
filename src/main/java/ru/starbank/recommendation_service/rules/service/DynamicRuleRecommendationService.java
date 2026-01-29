package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import ru.starbank.recommendation_service.dto.RecommendationDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DynamicRuleRecommendationService {

    private final RuleRepository ruleRepository;
    private final RuleConditionEvaluator ruleConditionEvaluator;
    private final RuleStatService ruleStatService;

    public List<RecommendationDto> recommend(UUID userId) {

        List<RuleEntity> rules = ruleRepository.findAll();

        return rules.stream()
                .filter(rule -> {
                    boolean matched = rule.getConditions()
                            .stream()
                            .allMatch(condition ->
                                    ruleConditionEvaluator.evaluate(userId, condition)
                            );

                    if (matched) {
                        // считаем статистику ТОЛЬКО если правило сработало
                        ruleStatService.increment(rule);
                    }

                    return matched;
                })
                .map(rule -> new RecommendationDto(
                        rule.getProductId(),
                        rule.getProductName(),
                        rule.getProductText()
                ))
                .toList();
    }
}