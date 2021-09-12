package br.com.dio.peopleManager.repository;

import br.com.dio.peopleManager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
