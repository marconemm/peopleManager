package br.com.dio.peopleManager.models;

import br.com.dio.peopleManager.dto.request.PersonDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50 ,nullable = false)
    private String name;

    @Column(length = 100)
    private String surname;

    @Column(unique = true, length = 14, nullable = false)
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phonesList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Phone> getPhonesList() {
        return phonesList;
    }

    public void setPhonesList(List<Phone> phonesList) {
        this.phonesList = phonesList;
    }

    public static Person toModel(PersonDTO personDTO) {
        Person validPerson = new Person();

        validPerson.setId(personDTO.getId());
        validPerson.setName(personDTO.getName());
        validPerson.setSurname(personDTO.getSurname());
        validPerson.setCpf(personDTO.getCpf());
        validPerson.setBirthDate(personDTO.getBirthDate());
        validPerson.setPhonesList(personDTO.getPhonesList().stream()
                .map(Phone::toModel).collect(Collectors.toList()));

        return validPerson;
    }
}
