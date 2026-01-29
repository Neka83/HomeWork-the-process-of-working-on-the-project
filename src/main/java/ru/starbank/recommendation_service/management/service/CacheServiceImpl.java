package ru.starbank.recommendation_service.management.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

    @Override
    public void clearAll() {
        // Заглушка по ТЗ — позже тут будет реальная очистка кешей
        log.info("All recommendation caches have been cleared");
    }
}