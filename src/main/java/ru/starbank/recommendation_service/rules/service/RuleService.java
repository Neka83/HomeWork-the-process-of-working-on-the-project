package ru.starbank.recommendation_service.rules.service;

import ru.starbank.recommendation_service.rules.dto.RuleDto;
import ru.starbank.recommendation_service.rules.dto.RuleListResponseDto;

import java.util.UUID;

public interface RuleService {

    RuleDto create(RuleDto dto);

    RuleListResponseDto getAll();

    void deleteById(UUID id);
}
