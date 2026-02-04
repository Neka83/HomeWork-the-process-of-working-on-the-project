package ru.starbank.recommendation_service.rules.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserActivityService {

    // USER_OF
    public boolean isUserOf(UUID userId, String productType) {
        // ⚠️ имитация, но сигнатура корректная
        return true;
    }

    // ACTIVE_USER_OF
    public boolean isActiveUserOf(UUID userId, String productType) {
        // имитация: активный пользователь
        return userId.toString().startsWith("111");
    }

    // TRANSACTION_SUM_COMPARE
    public boolean compareTransactionSum(
            UUID userId,
            String productType,
            String transactionType,
            String operator,
            int value
    ) {
        // имитация суммы
        int fakeSum = 150_000;

        return switch (operator) {
            case ">" -> fakeSum > value;
            case "<" -> fakeSum < value;
            case "=" -> fakeSum == value;
            case ">=" -> fakeSum >= value;
            case "<=" -> fakeSum <= value;
            default -> false;
        };
    }

    // TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW
    public boolean compareDepositWithdraw(
            UUID userId,
            String productType,
            String operator
    ) {
        int deposit = 200_000;
        int withdraw = 50_000;

        return switch (operator) {
            case ">" -> deposit > withdraw;
            case "<" -> deposit < withdraw;
            case "=" -> deposit == withdraw;
            case ">=" -> deposit >= withdraw;
            case "<=" -> deposit <= withdraw;
            default -> false;
        };
    }
}