package com.example.demo.controller;

import com.example.demo.entity.PersonEntity;
import com.example.demo.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("users")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    List<PersonEntity> getPersonInfoById(@PathVariable Long id) {
        return this.personService.getPersonInfoById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void addPerson(@RequestBody @Valid PersonEntity personEntity) {
        this.personService.addPerson(personEntity);
    }
}
