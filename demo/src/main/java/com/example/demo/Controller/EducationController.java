package com.example.demo.Controller;
// GTB: - ↑ package name 里一般不会使用大写字母，其它地方同理
import com.example.demo.Dto.EducationInfo;
import com.example.demo.Service.EducationService;
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

    // GTB: - "/educations" 可以都集中放到 class 一级的@RequestMapping里去了
    @GetMapping("/educations")
    List<EducationInfo> getEducationInfoById(@PathVariable Long userId) {
        return this.educationService.getEducationInfoById(userId);
    }

    @PostMapping("/educations")
    @ResponseStatus(HttpStatus.CREATED)
    void addEducationInfo(@PathVariable Long userId,
                          @RequestBody @Valid EducationInfo educationInfo) {
        this.educationService.addEducationInfo(userId, educationInfo);
    }
}
