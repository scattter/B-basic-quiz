package com.example.demo.service;

import com.example.demo.entity.EducationEntity;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserIdNotExistException;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository educationRepository;
    private final PersonRepository personRepository;

    public EducationService(EducationRepository educationRepository, PersonRepository personRepository) {
        this.educationRepository = educationRepository;
        this.personRepository = personRepository;

        PersonEntity personEntity = PersonEntity.builder()
                .id(1)
                .name("KAMIL")
                .age(24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        this.personRepository.save(personEntity);

        EducationEntity info1 = EducationEntity.builder()
                .title("Secondary school specializing in artistic")
                .year(2005)
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .build();
        EducationEntity info2 = EducationEntity.builder()
                .title("First level graduation in Graphic Design")
                .year(2009)
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .build();
        info1.setPersonEntity(personRepository.findAllById((long) 1).get(0));
        info2.setPersonEntity(personRepository.findAllById((long) 1).get(0));
        this.educationRepository.save(info1);
        this.educationRepository.save(info2);
    }


    public List<EducationEntity> getEducationInfoById(Long userId) {
        return this.educationRepository.findAllByUserId(userId);
    }

    public void addEducationInfo(Long userId, EducationEntity educationEntity) {
        if (personRepository.findAllById(userId).size() == 0) {
            throw new UserIdNotExistException("this user isn't exist");
        } else {
            educationEntity.setPersonEntity(personRepository.findAllById(userId).get(0));
        }
        this.educationRepository.save(educationEntity);
    }
}
