package ru.starbank.recommendation_service.rules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.dto.RuleDto;
import ru.starbank.recommendation_service.rules.entity.RuleConditionEntity;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final RuleRepository ruleRepository;

    @Override
    public RuleDto create(RuleDto dto) {

        RuleEntity entity = new RuleEntity();
        entity.setProductName(dto.getProductName());
        entity.setProductId(dto.getProductId());
        entity.setProductText(dto.getProductText());

        List<RuleConditionEntity> conditions = dto.getRules().stream()
                .map(c -> {
                    RuleConditionEntity e = new RuleConditionEntity();
                    e.setQuery(c.getQuery());
                    e.setArguments(String.join(",", c.getArguments()));
                    e.setNegate(c.isNegate());
                    e.setRule(entity);
                    return e;
                })
                .collect(Collectors.toList());

        entity.setConditions(conditions);

        RuleEntity saved = ruleRepository.save(entity);
        dto.setId(saved.getId());

        return dto;
    }

    @Override
    public List<RuleDto> findAll() {
        return ruleRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        ruleRepository.deleteById(id);
    }

    private RuleDto toDto(RuleEntity entity) {
        RuleDto dto = new RuleDto();
        dto.setId(entity.getId());
        dto.setProductName(entity.getProductName());
        dto.setProductId(entity.getProductId());
        dto.setProductText(entity.getProductText());
        return dto;
    }
}