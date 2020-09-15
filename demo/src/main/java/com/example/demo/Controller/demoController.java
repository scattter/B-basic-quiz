package com.example.demo.Controller;

import com.example.demo.Dto.PersonInfo;
import com.example.demo.Service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class demoController {

    private final PersonService personService;

    public demoController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    PersonInfo getPersonInfoById(@PathVariable Integer id) {
        return this.personService.getPersonInfoById(id);
    }
}
