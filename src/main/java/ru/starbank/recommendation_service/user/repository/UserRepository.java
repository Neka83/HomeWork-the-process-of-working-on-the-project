package ru.starbank.recommendation_service.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.starbank.recommendation_service.user.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsernameIgnoreCase(String username);
}
