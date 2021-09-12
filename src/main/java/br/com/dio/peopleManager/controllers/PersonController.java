package br.com.dio.peopleManager.controllers;

import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.exceptions.*;
import br.com.dio.peopleManager.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/person")
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

    @GetMapping
    public List<PersonDTO> getAll(){
        return personService.listAll();

    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable long id) throws PersonNotFoundException {
        return  personService.getById(id);
    }

    @PutMapping
    public String updatePerson(@RequestBody PersonDTO data) throws PersonNotFoundException, IdNotInformedException {

        return personService.updatePerson(data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteById(@PathVariable long id) throws PersonNotFoundException{
        PersonDTO personToRemove = personService.getById(id);

        personService.deleteById(personToRemove.getId());

    }
}
