package ru.starbank.recommendation_service.rules.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RuleDto {

    private UUID id;
    private String productName;
    private String productText;

    // список условий правила
    private List<RuleConditionDto> rules = new ArrayList<>();

    // ===== getters =====

    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductText() {
        return productText;
    }

    public List<RuleConditionDto> getRules() {
        return rules;
    }

    // ===== setters =====

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public void setRules(List<RuleConditionDto> rules) {
        this.rules = rules;
    }
}