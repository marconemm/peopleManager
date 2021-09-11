package br.com.dio.peopleManager.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50 ,nullable = false)
    private String name;

    @Column(length = 100)
    private String surname;

    @Column(unique = true, length = 14, nullable = false)
    private String cpf;

    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phonesList;

    public Person(){
        this.id = 0;
        this.name = null;
        this.surname = null;
        this.cpf = null;
        this.birthDate = null;
        this.phonesList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCPF() {
        return cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Phone getPhone(int index) {
        return phonesList.get(index);
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

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhonesList(Phone phone) {
        phonesList.add(phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(cpf, person.cpf) && Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, cpf, birthDate);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
