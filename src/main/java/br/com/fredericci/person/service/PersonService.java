package br.com.fredericci.person.service;

import br.com.fredericci.person.exception.NotFoundException;
import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.repository.PersonRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import java.io.IOException;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public void loadDatabase() throws IOException {

        Fixture.of(Person.class).addTemplate("valid", new Rule() {{
            add("id", random(Long.class));
            add("name", firstName());
            add("surname", lastName());
        }});

        IntStream.range(1, 10).forEach((number) -> personRepository.save(Fixture.from(Person.class).gimme("valid")));

    }

    public Person findById(Long personId) {
        return this.personRepository.findById(personId).orElseThrow(() -> new NotFoundException());
    }
}

