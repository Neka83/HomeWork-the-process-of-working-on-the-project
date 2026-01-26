package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;

import java.util.UUID;

@Service
public class RuleConditionEvaluatorImpl implements RuleConditionEvaluator {

    private final UserActivityService userActivityService;

    public RuleConditionEvaluatorImpl(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @Override
    public boolean evaluate(UUID userId, RuleConditionEntity condition) {

        RuleConditionType type =
                RuleConditionType.from(condition.getQuery());

        // arguments хранятся как строка: "DEBIT,DEPOSIT,>,100000"
        String[] args = condition.getArguments().split(",");

        boolean result;

        switch (type) {

            case USER_OF:
                result = userActivityService.isUserOf(
                        userId,
                        args[0]
                );
                break;

            case ACTIVE_USER_OF:
                result = userActivityService.isActiveUserOf(
                        userId,
                        args[0]
                );
                break;

            case TRANSACTION_SUM_COMPARE:
                result = userActivityService.compareTransactionSum(
                        userId,
                        args[0], // product type
                        args[1], // transaction type
                        args[2], // operator
                        Integer.parseInt(args[3]) // value
                );
                break;

            case TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW:
                result = userActivityService.compareDepositWithdraw(
                        userId,
                        args[0], // product type
                        args[1]  // operator
                );
                break;

            default:
                result = false;
        }

        // ⚠️ ОБЯЗАТЕЛЬНО учитываем negate (по ТЗ)
        return condition.isNegate() ? !result : result;
    }
}