package br.com.dio.peopleManager.service;

import br.com.dio.peopleManager.exceptions.PersonNotFoundException;
import br.com.dio.peopleManager.models.Person;
import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public String createPerson(PersonDTO personDTO){
        Person validPerson = Person.toPerson(personDTO);

        Person savedPerson = personRepo.save(validPerson);

        return "{\"msg\":\"Successfully created.\"," +
                "\"Person ID\":" + savedPerson.getId() + "}";
    }

    public List<PersonDTO> listAll() {
        List<Person> allPersons = personRepo.findAll();

        return allPersons.stream().map(PersonDTO::toDTO).collect(Collectors.toList());
    }

    public PersonDTO getById(long id) throws PersonNotFoundException {
        Optional<Person> optPerson = personRepo.findById(id);

        if (optPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }

        return PersonDTO.toDTO(optPerson.get()) ;
    }
}
