package br.com.dio.peopleManager.service;

import br.com.dio.peopleManager.models.Person;
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

    public String createPerson(Person person){
        Person savedPerson = personRepo.save(person);

        return "{\"msg\":\"Successfully created.\"," +
                "\"Person ID\":" + savedPerson.getId() + "}";
    }
}
