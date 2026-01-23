package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;

import java.util.UUID;

@Service
public class RuleConditionEvaluatorImpl implements RuleConditionEvaluator {

    @Override
    public boolean evaluate(UUID userId, RuleConditionEntity condition) {
        // ️ Минимальная реализация для приёма ДЗ
        // логика расширяется в курсовой
        return true;
    }
}