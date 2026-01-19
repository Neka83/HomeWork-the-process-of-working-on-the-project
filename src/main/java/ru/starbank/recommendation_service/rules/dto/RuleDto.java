package ru.starbank.recommendation_service.rules.dto;

import java.util.List;
import java.util.UUID;

public class RuleDto {

    private UUID id;
    private String productName;
    private String productId;
    private String productText;
    private List<RuleConditionDto> rules;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public List<RuleConditionDto> getRules() {
        return rules;
    }

    public void setRules(List<RuleConditionDto> rules) {
        this.rules = rules;
    }
}