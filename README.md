# Recommendation Service

## 📌 Description
Recommendation Service is a Spring Boot backend application that provides product recommendations to users.

Recommendations are generated using:
- static rules
- dynamic rules (managed by managers)

The service exposes:
- REST API
- Telegram Bot
- Management endpoints

---

## 🛠 Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database
- Liquibase
- Maven
- Telegram Bot API
- OpenAPI (Swagger)

---

## 👥 Actors
- User — receives recommendations via REST API or Telegram
- Manager — manages dynamic rules and views statistics
- External system — clears cache and checks service health/info

---

## 🚀 Run locally

### Build project

./mvnw clean package


### Run application


java -jar target/recommendation-service.jar


Application will start on:


http://localhost:8080


---

## 📚 API Documentation
After start open:


http://localhost:8080/swagger-ui.html


---

## 🔧 Environment Variables

| Variable | Description |
|----------|-------------|
SPRING_DATASOURCE_URL | database url |
SPRING_DATASOURCE_USERNAME | db username |
SPRING_DATASOURCE_PASSWORD | db password |
TELEGRAM_BOT_TOKEN | telegram bot token |

---

## 📖 Project Documentation
See GitHub Wiki for:
- Requirements
- Architecture diagrams
- Deployment guide.