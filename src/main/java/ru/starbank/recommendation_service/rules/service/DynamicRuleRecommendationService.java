package ru.starbank.recommendation_service.rules.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.dto.RecommendationDto;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DynamicRuleRecommendationService {

    private final RuleRepository ruleRepository;
    private final RuleStatService ruleStatService;

    public List<RecommendationDto> recommend(UUID userId) {

        return ruleRepository.findAll()
                .stream()
                .map(rule -> {

                    // 🔥 PoC: считаем, что правило ВСЕГДА срабатывает
                    ruleStatService.increment(rule);

                    return new RecommendationDto(
                            rule.getProductId(),
                            rule.getProductName(),
                            rule.getProductText()
                    );
                })
                .toList();
    }
}


