package ru.starbank.recommendation_service.rules.service;

import ru.starbank.recommendation_service.rules.dto.RuleStatDto;

import java.util.List;

public interface RuleStatService {

    void increment(ru.starbank.recommendation_service.rules.entity.RuleEntity rule);

    List<RuleStatDto> getStats();
}
