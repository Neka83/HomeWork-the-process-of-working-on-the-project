package ru.starbank.recommendation_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.starbank.recommendation_service.dto.RecommendationResponse;
import ru.starbank.recommendation_service.service.RecommendationService;

@RestController
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/recommendation/{userId}")
    public RecommendationResponse getRecommendation(
            @PathVariable String userId
    ) {
        return new RecommendationResponse(
                userId,
                recommendationService.getRecommendations(userId)
        );
    }

    @GetMapping("/ping")
    public String ping() {
        return "OK";
    }
}