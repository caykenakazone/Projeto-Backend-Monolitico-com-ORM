package com.iftm.firststructure.controllers;


import com.iftm.firststructure.models.Person;
import com.iftm.firststructure.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PersonController {

    //INjeção de dependências
    @Autowired
    private PersonService personService;
    //CRUD
    //READ - HTTP GET
    @GetMapping("persons")
    public List<Person> findAll(){
        return personService.findAll();
    }
    @GetMapping("person/{id}")
    public Optional<Person> find(@PathVariable("id") Long id){
        return personService.findById(id);
    }

    //CREATE - HTTP POST
    @PostMapping("person")
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }

    //UPDATE - HTTP PUT
    @PutMapping("person")
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }
    //DELETE -HTTP DELETE
    @DeleteMapping("person/{id}")
    public String delete(@PathVariable("id") Long id){
        return personService.delete(id);
    }
}
