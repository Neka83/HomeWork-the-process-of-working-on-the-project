package ru.starbank.recommendation_service.rules.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rules")
public class RuleEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String productName;

    private UUID productId;

    private String productText;

    @OneToMany(mappedBy = "rule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RuleConditionEntity> conditions;

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

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductText() {
        return productText;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public List<RuleConditionEntity> getConditions() {
        return conditions;
    }

    public void setConditions(List<RuleConditionEntity> conditions) {
        this.conditions = conditions;
    }
}