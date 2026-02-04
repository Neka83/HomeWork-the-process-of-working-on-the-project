package ru.starbank.recommendation_service.rules.service;

public enum RuleConditionType {

    USER_OF,
    ACTIVE_USER_OF,
    TRANSACTION_SUM_COMPARE,
    TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW;

    public static RuleConditionType from(String value) {
        return RuleConditionType.valueOf(value);
    }
}