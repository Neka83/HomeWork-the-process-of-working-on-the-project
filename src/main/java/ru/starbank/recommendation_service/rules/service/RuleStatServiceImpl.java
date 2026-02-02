package ru.starbank.recommendation_service.rules.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.dto.RuleStatDto;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.entity.RuleStatEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;
import ru.starbank.recommendation_service.rules.repository.RuleStatRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuleStatServiceImpl implements RuleStatService {

    private final RuleStatRepository ruleStatRepository;
    private final RuleRepository ruleRepository;

    // =====================
    // INCREMENT
    // =====================
    @Override
    @Transactional
    public void increment(RuleEntity rule) {

        RuleStatEntity stat = ruleStatRepository
                .findByRule(rule)
                .orElseGet(() -> {
                    RuleStatEntity newStat = new RuleStatEntity();
                    newStat.setRule(rule);
                    newStat.setCount(0L);
                    return newStat;
                });

        stat.setCount(stat.getCount() + 1);
        ruleStatRepository.save(stat);
    }

    // =====================
    // GET STATS (ВАЖНО)
    // =====================
    @Override
    public List<RuleStatDto> getStats() {

        // все правила
        List<RuleEntity> rules = ruleRepository.findAll();

        // статистика, которая есть в БД
        Map<RuleEntity, Long> statsMap = ruleStatRepository.findAll()
                .stream()
                .collect(Collectors.toMap(
                        RuleStatEntity::getRule,
                        RuleStatEntity::getCount
                ));

        // возвращаем ВСЕ правила, даже с 0
        return rules.stream()
                .map(rule -> new RuleStatDto(
                        rule.getId(),
                        statsMap.getOrDefault(rule, 0L)
                ))
                .toList();
    }
}
