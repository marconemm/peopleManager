package br.com.dio.peopleManager.service;

import br.com.dio.peopleManager.models.Person;
import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
