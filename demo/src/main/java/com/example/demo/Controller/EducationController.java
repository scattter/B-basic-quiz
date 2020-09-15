package com.example.demo.Controller;

import com.example.demo.Dto.EducationInfo;
import com.example.demo.Service.EducationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}")
public class EducationController {
    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/education")
    List<EducationInfo> getEducationInfoById(@PathVariable Integer userId) {
        return this.educationService.getEducationInfoById(userId);
    }
}
