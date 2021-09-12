package br.com.dio.peopleManager.controllers;

import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody @Valid PersonDTO personDTO){
        return  personService.createPerson(personDTO);
    }
}
