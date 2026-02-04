package ru.starbank.recommendation_service.rules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.dto.RuleConditionDto;
import ru.starbank.recommendation_service.rules.dto.RuleDto;
import ru.starbank.recommendation_service.rules.dto.RuleListResponseDto;
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

    /**
     * Creates or updates dynamic rule.
     */
    @Override
    public RuleDto create(RuleDto dto) {

        RuleEntity rule = new RuleEntity();
        rule.setId(UUID.randomUUID());
        rule.setProductId(dto.getProductId());
        rule.setProductName(dto.getProductName());
        rule.setProductText(dto.getProductText());

        List<RuleConditionEntity> conditions = dto.getRules().stream()
                .map(c -> {
                    RuleConditionEntity e = new RuleConditionEntity();
                    e.setQuery(c.getQuery());
                    e.setArguments(String.join(",", c.getArguments()));
                    e.setNegate(c.isNegate());
                    e.setRule(rule);
                    return e;
                })
                .toList();

        rule.setConditions(conditions);

        ruleRepository.save(rule);

        return dto;
    }

    // =========================
    // GET ALL RULES
    // =========================
    @Override
    public RuleListResponseDto getAll() {

        List<RuleDto> rules = ruleRepository.findAll()
                .stream()
                .map(rule -> {
                    RuleDto dto = new RuleDto();
                    dto.setId(rule.getId());
                    dto.setProductId(rule.getProductId());
                    dto.setProductName(rule.getProductName());
                    dto.setProductText(rule.getProductText());

                    List<RuleConditionDto> conditions = rule.getConditions()
                            .stream()
                            .map(c -> {
                                RuleConditionDto cd = new RuleConditionDto();
                                cd.setQuery(c.getQuery());
                                cd.setArguments(List.of(c.getArguments().split(",")));
                                cd.setNegate(c.isNegate());
                                return cd;
                            })
                            .toList();

                    dto.setRules(conditions);
                    return dto;
                })
                .toList();

        return new RuleListResponseDto(rules);
    }

    // =========================
    // DELETE RULE
    // =========================
    @Override
    public void deleteById(UUID id) {
        ruleRepository.deleteById(id);
    }
}
