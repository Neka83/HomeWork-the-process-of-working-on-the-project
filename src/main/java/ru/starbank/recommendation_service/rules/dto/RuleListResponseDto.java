package ru.starbank.recommendation_service.rules.dto;

import java.util.List;

public class RuleListResponseDto {

    private List<RuleDto> data;

    public RuleListResponseDto(List<RuleDto> data) {
        this.data = data;
    }

    public List<RuleDto> getData() {
        return data;
    }

    public void setData(List<RuleDto> data) {
        this.data = data;
    }
}