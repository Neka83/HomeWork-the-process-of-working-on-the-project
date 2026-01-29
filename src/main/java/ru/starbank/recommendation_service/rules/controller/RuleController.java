package ru.starbank.recommendation_service.rules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.starbank.recommendation_service.rules.dto.RuleDto;
import ru.starbank.recommendation_service.rules.dto.RuleListResponseDto;
import ru.starbank.recommendation_service.rules.dto.RuleStatsResponseDto;
import ru.starbank.recommendation_service.rules.service.RuleService;
import ru.starbank.recommendation_service.rules.service.RuleStatService;

import java.util.UUID;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;
    private final RuleStatService ruleStatService;

    // =========================
    // CREATE RULE
    // =========================
    @PostMapping
    public RuleDto create(@RequestBody RuleDto dto) {
        return ruleService.create(dto);
    }

    // =========================
    // GET ALL RULES
    // =========================
    @GetMapping
    public RuleListResponseDto getAll() {
        return ruleService.getAll();
    }

    // =========================
    // DELETE RULE
    // =========================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ruleService.deleteById(id);
    }

    // =========================
    // GET RULE STATS
    // =========================
    @GetMapping("/stats")
    public RuleStatsResponseDto getStats() {
        return new RuleStatsResponseDto(ruleStatService.getStats());
    }
}
