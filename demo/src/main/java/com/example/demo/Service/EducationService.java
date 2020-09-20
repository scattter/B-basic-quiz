package com.example.demo.service;

import com.example.demo.entity.EducationEntity;
import com.example.demo.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
        EducationEntity info1 = EducationEntity.builder()
                .userId((long) 1)
                .title("Secondary school specializing in artistic")
                .year((long) 2005)
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        EducationEntity info2 = EducationEntity.builder()
                .userId((long) 1)
                .title("First level graduation in Graphic Design")
                .year((long) 2009)
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .build();
        this.educationRepository.save(info1);
        this.educationRepository.save(info2);
    }

    public List<EducationEntity> getEducationInfoById(Long userId) {
        return this.educationRepository.findAllByUserId(userId);
    }

    public void addEducationInfo(Long userId, EducationEntity educationInfo) {
        this.educationRepository.save(educationInfo);
    }
}
