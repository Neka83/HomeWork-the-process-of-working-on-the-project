package ru.starbank.recommendation_service.rules.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.rules.dto.RuleStatDto;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.entity.RuleStatEntity;
import ru.starbank.recommendation_service.rules.repository.RuleRepository;
import ru.starbank.recommendation_service.rules.repository.RuleStatRepository;
import java.util.UUID;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RuleStatServiceImpl implements RuleStatService {

    private final RuleStatRepository ruleStatRepository;
    private final RuleRepository ruleRepository;

    // =========================
    // INCREMENT STAT
    // =========================
    @Override
    @Transactional
    public void increment(RuleEntity rule) {
        RuleStatEntity stat = ruleStatRepository
                .findByRule(rule)
                .orElseGet(() -> {
                    RuleStatEntity s = new RuleStatEntity();
                    s.setRule(rule);
                    return s;
                });

        stat.increment();
        ruleStatRepository.save(stat);
    }

    // =========================
    // GET ALL STATS (WITH ZERO)
    // =========================
    @Override
    public List<RuleStatDto> getStats() {

        // 1️⃣ Все правила
        List<RuleEntity> allRules = ruleRepository.findAll();

        // 2️⃣ Вся существующая статистика
        Map<UUID, RuleStatEntity> statsByRuleId =
                ruleStatRepository.findAll()
                        .stream()
                        .collect(Collectors.toMap(
                                stat -> stat.getRule().getId(),
                                stat -> stat
                        ));

        // 3️⃣ Собираем ответ
        return allRules.stream()
                .map(rule -> {
                    RuleStatEntity stat = statsByRuleId.get(rule.getId());
                    long count = (stat != null) ? stat.getCount() : 0;

                    return new RuleStatDto(rule.getId(), count);
                })
                .toList();
    }
}