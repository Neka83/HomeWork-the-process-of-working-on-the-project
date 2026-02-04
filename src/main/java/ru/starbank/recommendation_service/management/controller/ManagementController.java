package ru.starbank.recommendation_service.management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.starbank.recommendation_service.management.service.CacheService;

@RestController
@RequiredArgsConstructor
public class ManagementController {

    private final CacheService cacheService;

    @PostMapping("/management/clear-caches")
    public void clearCaches() {
        cacheService.clearAll();
    }
}