package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DynamicRuleRecommendationService {

    private final RuleRepository ruleRepository;
    private final RuleConditionEvaluator ruleConditionEvaluator;

    public DynamicRuleRecommendationService(
            RuleRepository ruleRepository,
            RuleConditionEvaluator ruleConditionEvaluator
    ) {
        this.ruleRepository = ruleRepository;
        this.ruleConditionEvaluator = ruleConditionEvaluator;
    }

    public List<String> getRecommendations(UUID userId) {
        List<String> result = new ArrayList<>();

        List<RuleEntity> rules = ruleRepository.findAll();

        for (RuleEntity rule : rules) {
            boolean rulePassed = true;

            for (RuleConditionEntity condition : rule.getConditions()) {
                boolean conditionResult =
                        ruleConditionEvaluator.evaluate(userId, condition);

                if (!conditionResult) {
                    rulePassed = false;
                    break;
                }
            }

            if (rulePassed) {
                result.add(rule.getProductName());
            }
        }

        return result;
    }
}