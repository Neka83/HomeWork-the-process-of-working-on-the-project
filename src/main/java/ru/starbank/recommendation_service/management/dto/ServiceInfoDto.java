package ru.starbank.recommendation_service.management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ServiceInfoDto {

    private String name;
    private String version;
}