package io.zipcoder.crudapp.controllers;

import io.zipcoder.crudapp.models.Person;
import io.zipcoder.crudapp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/users")
    Person createPerson(Person p){ return null; }

    @GetMapping("/users/{id}")
    Person getPerson(@PathVariable int id){ return null; }

    @GetMapping("/users")
    List<Person> getPersonList(){ return null; }

    @PutMapping("/users/{id}")
    Person updatePerson(@PathVariable Person p){ return null; }

    @DeleteMapping("/users/{id}")
    void DeletePerson(@PathVariable int id) {}
}
