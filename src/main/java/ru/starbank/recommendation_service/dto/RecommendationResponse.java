package ru.starbank.recommendation_service.dto;

import java.util.List;

public class RecommendationResponse {

    private String user_id;
    private List<RecommendationDto> recommendations;

    public RecommendationResponse(String user_id, List<RecommendationDto> recommendations) {
        this.user_id = user_id;
        this.recommendations = recommendations;
    }

    public String getUser_id() {
        return user_id;
    }

    public List<RecommendationDto> getRecommendations() {
        return recommendations;
    }
}