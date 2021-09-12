package br.com.dio.peopleManager.service;

import br.com.dio.peopleManager.dto.request.PersonDTO;
import br.com.dio.peopleManager.exceptions.IdNotInformedException;
import br.com.dio.peopleManager.exceptions.PersonNotFoundException;
import br.com.dio.peopleManager.models.Person;
import br.com.dio.peopleManager.models.Phone;
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
        Person validPerson = Person.toModel(personDTO);

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

        return PersonDTO.toDTO(optPerson.get());
    }

    public void deleteById(long id) {

        personRepo.deleteById(id);
    }

    public String updatePerson(PersonDTO data) throws PersonNotFoundException, IdNotInformedException {

        if (data.getId() == 0) {
            throw new IdNotInformedException("Please, inform the person ID.");
        }

        Optional<Person> optPerson = personRepo.findById(data.getId());

        if (optPerson.isEmpty()) {
            throw new PersonNotFoundException(data.getId());
        }

        Person personToUpdate = Person.toModel(data);


        for (int i = 0; i < personToUpdate.getPhonesList().size() ; i++) {
            Phone currentPhone = personToUpdate.getPhonesList().get(i);
            if (currentPhone.getId() == 0) {
                throw new IdNotInformedException("Please, inform the " + currentPhone.getNumber() + " phone ID.");
            }
        }

        Person updatedPerson = personRepo.save(personToUpdate);

        return "{\"msg\":\"Successfully updated.\"," +
                "\"Person ID\":" + updatedPerson.getId() + "}";

    }
}
