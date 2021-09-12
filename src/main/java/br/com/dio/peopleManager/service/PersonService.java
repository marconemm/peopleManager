package br.com.dio.peopleManager.service;

import br.com.dio.peopleManager.models.Person;
import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public String createPerson(PersonDTO personDTO){
        Person validPerson = new Person();
        validPerson.setName(personDTO.getName());
        validPerson.setSurname(personDTO.getSurname());
        validPerson.setCpf(personDTO.getCpf());
        validPerson.setBirthDate(personDTO.getBirthDate());
        validPerson.setPhonesList(personDTO.getPhonesList());

        Person savedPerson = personRepo.save(validPerson);

        return "{\"msg\":\"Successfully created.\"," +
                "\"Person ID\":" + savedPerson.getId() + "}";
    }

    public List<PersonDTO> listAll() {
        List<Person> allPersons = personRepo.findAll();

        return allPersons.stream().map(person -> {
            PersonDTO personDTO = new PersonDTO();

            personDTO.setId(person.getId());
            personDTO.setName(person.getName());
            personDTO.setSurname(person.getSurname());
            personDTO.setCpf(person.getCpf());
            personDTO.setBirthDate(person.getBirthDate());
            personDTO.setPhonesList(person.getPhonesList());

            return  personDTO;

        }).collect(Collectors.toList());
    }
}
