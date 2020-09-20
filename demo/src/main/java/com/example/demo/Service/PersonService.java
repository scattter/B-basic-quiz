package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        PersonEntity personEntity = PersonEntity.builder()
                .id((long) 1)
                .name("KAMIL")
                .age((long) 24)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .build();
        this.personRepository.save(personEntity);
    }


    public List<PersonEntity> getPersonInfoById(Long id) {
        return this.personRepository.findAllById(id);
    }

    public void addPerson(PersonEntity personEntity) {
        this.personRepository.save(personEntity);
    }
}
