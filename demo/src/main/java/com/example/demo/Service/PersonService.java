package com.example.demo.Service;

import com.example.demo.Dto.PersonInfo;
import com.example.demo.Repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonInfo getPersonInfoById(Long id) {
        return this.personRepository.findById(id);
    }

    public void addPerson(PersonInfo personInfo) {
        this.personRepository.save(personInfo);
    }
}
