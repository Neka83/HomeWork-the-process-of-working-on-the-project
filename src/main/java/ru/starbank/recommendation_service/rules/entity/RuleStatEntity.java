package ru.starbank.recommendation_service.rules.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rule_stats")
public class RuleStatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "rule_id")
    private RuleEntity rule;

    @Column(nullable = false)
    private long count = 0;

    // ===== getters =====

    public Long getId() {
        return id;
    }

    public RuleEntity getRule() {
        return rule;
    }

    public long getCount() {
        return count;
    }

    // ===== setters =====

    public void setRule(RuleEntity rule) {
        this.rule = rule;
    }

    public void setCount(long count) {
        this.count = count;
    }

    // ===== business logic =====

    public void increment() {
        this.count++;
    }
}