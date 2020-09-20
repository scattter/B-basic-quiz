package com.example.demo.controller;

import com.example.demo.entity.EducationEntity;
import com.example.demo.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users/{userId}")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/educations")
    List<EducationEntity> getEducationInfoById(@PathVariable Long userId) {
        return this.educationService.getEducationInfoById(userId);
    }

    @PostMapping("/educations")
    @ResponseStatus(HttpStatus.CREATED)
    void addEducationInfo(@PathVariable Long userId,
                          @RequestBody @Valid EducationEntity educationEntity) {
        this.educationService.addEducationInfo(userId, educationEntity);
    }
}
