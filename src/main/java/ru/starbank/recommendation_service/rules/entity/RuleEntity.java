package ru.starbank.recommendation_service.rules.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rules")
public class RuleEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_text", nullable = false)
    private String productText;

    @OneToMany(
            mappedBy = "rule",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<RuleConditionEntity> conditions = new ArrayList<>();

    // ===== getters =====

    public UUID getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductText() {
        return productText;
    }

    public List<RuleConditionEntity> getConditions() {
        return conditions;
    }

    // ===== setters =====

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductText(String productText) {
        this.productText = productText;
    }

    public void setConditions(List<RuleConditionEntity> conditions) {
        this.conditions = conditions;
    }
}