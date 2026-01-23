package ru.starbank.recommendation_service.rules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.dto.RuleConditionDto;
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

        RuleEntity rule = new RuleEntity();
        rule.setProductName(dto.getProductName());
        rule.setProductText(dto.getProductText());

        List<RuleConditionEntity> conditions =
                dto.getRules().stream()
                        .map(c -> {
                            RuleConditionEntity e = new RuleConditionEntity();
                            e.setQuery(c.getQuery());
                            e.setArguments(String.join(",", c.getArguments()));
                            e.setNegate(c.isNegate());
                            e.setRule(rule);
                            return e;
                        })
                        .collect(Collectors.toList());

        rule.setConditions(conditions);

        RuleEntity saved = ruleRepository.save(rule);
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
        dto.setProductText(entity.getProductText());
        dto.setRules(List.of());
        return dto;
    }
}