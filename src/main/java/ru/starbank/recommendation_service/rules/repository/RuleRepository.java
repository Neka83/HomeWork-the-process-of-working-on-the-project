package ru.starbank.recommendation_service.rules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;

import java.util.UUID;

public interface RuleRepository extends JpaRepository<RuleEntity, UUID> {
}