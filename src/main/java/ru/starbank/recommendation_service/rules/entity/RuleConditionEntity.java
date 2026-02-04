package ru.starbank.recommendation_service.rules.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rule_conditions")
public class RuleConditionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String query;

    @Column(length = 1000)
    private String arguments;

    private boolean negate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id", nullable = false)
    private RuleEntity rule;

    // ===== getters =====

    public Long getId() {
        return id;
    }

    public String getQuery() {
        return query;
    }

    public String getArguments() {
        return arguments;
    }

    public boolean isNegate() {
        return negate;
    }

    public RuleEntity getRule() {
        return rule;
    }

    // ===== setters =====

    public void setQuery(String query) {
        this.query = query;
    }

    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    public void setNegate(boolean negate) {
        this.negate = negate;
    }

    public void setRule(RuleEntity rule) {
        this.rule = rule;
    }
}