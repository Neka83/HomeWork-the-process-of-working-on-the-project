package ru.starbank.recommendation_service.rules.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.starbank.recommendation_service.rules.entity.RuleEntity;
import ru.starbank.recommendation_service.rules.entity.RuleStatEntity;

import java.util.Optional;

public interface RuleStatRepository extends JpaRepository<RuleStatEntity, Long> {

    Optional<RuleStatEntity> findByRule(RuleEntity rule);
}
