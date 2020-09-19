package com.example.demo.service;

import com.example.demo.entity.EducationInfo;
import com.example.demo.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<EducationInfo> getEducationInfoById(Long userId) {
        return this.educationRepository.getEducationInfoById(userId);
    }

    public void addEducationInfo(Long userId, EducationInfo educationInfo) {
        this.educationRepository.save(userId, educationInfo);
    }
}
