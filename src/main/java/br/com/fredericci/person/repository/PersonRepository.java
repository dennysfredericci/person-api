package br.com.fredericci.person.repository;


import br.com.fredericci.person.model.Person;
import java.util.UUID;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface PersonRepository extends JpaRepositoryImplementation<Person, UUID> {
}
