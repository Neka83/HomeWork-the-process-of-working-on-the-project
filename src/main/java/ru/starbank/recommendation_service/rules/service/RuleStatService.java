package ru.starbank.recommendation_service.rules.service;

import ru.starbank.recommendation_service.rules.dto.RuleStatDto;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;

import java.util.List;

public interface RuleStatService {

    void increment(RuleEntity rule);

    List<RuleStatDto> getStats();
}
