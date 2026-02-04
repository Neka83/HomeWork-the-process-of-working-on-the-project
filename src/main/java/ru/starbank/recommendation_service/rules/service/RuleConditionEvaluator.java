package ru.starbank.recommendation_service.rules.service;

import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;

import java.util.UUID;

public interface RuleConditionEvaluator {

    boolean evaluate(UUID userId, RuleConditionEntity condition);
}