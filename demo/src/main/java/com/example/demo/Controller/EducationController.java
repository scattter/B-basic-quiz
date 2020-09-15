package com.example.demo.Controller;

import com.example.demo.Dto.EducationInfo;
import com.example.demo.Service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    List<EducationInfo> getEducationInfoById(@PathVariable Integer userId) {
        return this.educationService.getEducationInfoById(userId);
    }

    @PostMapping("/educations")
    @ResponseStatus(HttpStatus.CREATED)
    void addEducationInfo(@PathVariable Integer userId,
                          @RequestBody EducationInfo educationInfo) {
        this.educationService.addEducationInfo(userId, educationInfo);
    }
}
