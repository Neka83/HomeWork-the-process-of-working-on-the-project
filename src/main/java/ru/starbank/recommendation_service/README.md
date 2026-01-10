# Recommendation Service (MVP)

Spring Boot сервис рекомендаций для банка «Стар».

## Описание
Реализован MVP рекомендательного сервиса в рамках домашнего задания.

Сервис принимает `user_id` и возвращает список персональных рекомендаций банковских продуктов на основе правил.

## Технологии
- Java 17
- Spring Boot
- JdbcTemplate
- H2 Embedded Database (READ_ONLY)

## Источник данных
Используется встроенная база данных H2:
- `transaction.mv.db`
- режим подключения: READ_ONLY
- доступ только на чтение

## REST API

### Получение рекомендаций

GET /recommendation/{user_id}


#### Пример ответа
```json
{
  "user_id": "cd515076-5d8a-44be-930e-8d4fcb79f42d",
  "recommendations": []
}
Если рекомендации отсутствуют, возвращается пустой массив recommendations.

Архитектура

RecommendationController — REST API

RecommendationService — агрегация рекомендаций

RecommendationRepository — работа с БД через JdbcTemplate

RecommendationRuleSet — интерфейс правил рекомендаций

Реализации правил помечены @Component и инжектируются списком

Статус

MVP версия.
Бизнес-правила заложены структурно и могут быть расширены в следующих итерациях.