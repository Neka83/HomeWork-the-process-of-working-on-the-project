package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;

import java.util.UUID;

@Service
public class RuleConditionEvaluatorImpl implements RuleConditionEvaluator {

    @Override
    public boolean evaluate(UUID userId, RuleConditionEntity condition) {

        boolean result;

        switch (condition.getQuery()) {

            case "ALWAYS_TRUE":
                result = true;
                break;

            case "ALWAYS_FALSE":
                result = false;
                break;

            case "USER_ID_STARTS_WITH":
                result = userId.toString()
                        .startsWith(condition.getArguments());
                break;

            default:
                // неизвестное правило — считаем ложным
                result = false;
        }

        // поддержка negate
        return condition.isNegate() ? !result : result;
    }
}