package ru.starbank.recommendation_service.rules.dto;

import java.util.UUID;

public record RuleStatDto(
        UUID ruleId,
        Long count
) {}
