package br.com.fredericci.person.service;

import br.com.fredericci.person.exception.NotFoundException;
import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.repository.PersonRepository;
import io.beanmother.core.ObjectMother;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.IntStream;

@Service
public class PersonService {


    private final PersonRepository personRepository;


    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public Page<Person> findAll(PageRequest pageRequest) {
        return this.personRepository.findAll(pageRequest);
    }

    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    @PostConstruct
    public void loadDatabase() {

        final ObjectMother objectMother = ObjectMother.getInstance();

        IntStream.range(1, 100).forEach((number) -> personRepository.save(objectMother.bear("person", Person.class)));

    }

    public Person findById(Long personId) {
        return this.personRepository.findById(personId).orElseThrow(() -> new NotFoundException());
    }
}

