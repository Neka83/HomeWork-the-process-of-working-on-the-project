package ru.starbank.recommendation_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendationRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecommendationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /** Тест: база реально читается */
    public int countAllTransactions() {
        return jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM transactions",
                Integer.class
        );
    }
}