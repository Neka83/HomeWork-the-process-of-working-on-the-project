package ru.starbank.recommendation_service.rules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.starbank.recommendation_service.rules.dto.RuleDto;
import ru.starbank.recommendation_service.rules.service.RuleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
public class RuleController {

    private final RuleService ruleService;

    @PostMapping
    public RuleDto create(@RequestBody RuleDto dto) {
        return ruleService.create(dto);
    }

    @GetMapping
    public List<RuleDto> findAll() {
        return ruleService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        ruleService.deleteById(id);
    }
}