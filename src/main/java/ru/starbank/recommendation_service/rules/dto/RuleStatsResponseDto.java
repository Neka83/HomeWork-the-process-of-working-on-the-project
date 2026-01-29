package ru.starbank.recommendation_service.rules.dto;

import java.util.List;

public class RuleStatsResponseDto {

    private List<RuleStatDto> stats;

    public RuleStatsResponseDto(List<RuleStatDto> stats) {
        this.stats = stats;
    }

    public List<RuleStatDto> getStats() {
        return stats;
    }
}
