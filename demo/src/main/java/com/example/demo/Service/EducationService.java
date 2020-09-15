package com.example.demo.Service;

import com.example.demo.Dto.EducationInfo;
import com.example.demo.Repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public List<EducationInfo> getEducationInfoById(Integer userId) {
        return this.educationRepository.getEducationInfoById(userId);
    }

    public void addEducationInfo(Integer userId, EducationInfo educationInfo) {
        this.educationRepository.save(userId, educationInfo);
    }
}
