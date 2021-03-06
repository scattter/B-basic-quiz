package com.example.demo.Controller;

import com.example.demo.Dto.PersonInfo;
import com.example.demo.Service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("users")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    PersonInfo getPersonInfoById(@PathVariable Long id) {
        return this.personService.getPersonInfoById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void addPerson(@RequestBody @Valid PersonInfo personInfo) {
        this.personService.addPerson(personInfo);
    }
}
