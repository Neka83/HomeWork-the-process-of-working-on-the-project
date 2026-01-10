package ru.starbank.recommendation_service.service;

import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.dto.RecommendationDto;
import ru.starbank.recommendation_service.repository.RecommendationRepository;
import ru.starbank.recommendation_service.rules.RecommendationRuleSet;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository repository;
    private final List<RecommendationRuleSet> ruleSets;

    public RecommendationService(
            RecommendationRepository repository,
            List<RecommendationRuleSet> ruleSets
    ) {
        this.repository = repository;
        this.ruleSets = ruleSets;
    }

    public int testTransactionsCount() {
        return repository.countAllTransactions();
    }

    public List<RecommendationDto> getRecommendations(String userId) {
        return ruleSets.stream()
                .filter(rule -> rule.isApplicable(userId))
                .map(RecommendationRuleSet::getRecommendation)
                .toList();
    }
}