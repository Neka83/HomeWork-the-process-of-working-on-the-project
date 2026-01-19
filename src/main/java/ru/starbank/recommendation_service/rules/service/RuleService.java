package ru.starbank.recommendation_service.rules.service;

import ru.starbank.recommendation_service.rules.dto.RuleDto;

import java.util.List;
import java.util.UUID;

public interface RuleService {

    RuleDto create(RuleDto dto);

    List<RuleDto> findAll();

    void deleteById(UUID id);
}