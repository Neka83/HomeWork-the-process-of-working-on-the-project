package ru.starbank.recommendation_service.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starbank.recommendation_service.user.entity.UserEntity;
import ru.starbank.recommendation_service.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity findByUsername(String username) {
        return userRepository
                .findByUsernameIgnoreCase(username)
                .orElse(null);
    }
}
