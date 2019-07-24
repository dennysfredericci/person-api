package br.com.fredericci.person.service;

import br.com.fredericci.person.exception.NotFoundException;
import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.repository.PersonRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Log
@Service
public class PersonService {


    private final PersonRepository personRepository;

    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;

        Fixture.of(Person.class).addTemplate("valid", new Rule() {{
            add("id", random(UUID.class));
            add("name", firstName());
            add("surname", lastName());
        }});
    }


    public Page<Person> findAll(PageRequest pageRequest) {
        return this.personRepository.findAll(pageRequest);
    }

    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    public Person findById(String personId) {
        return this.personRepository.findById(UUID.fromString(personId)).orElseThrow(() -> new NotFoundException());
    }

    @PostConstruct
    public void loadDatabase() throws IOException {

        IntStream.range(1, 10).forEach((number) -> {
            final Person person = this.create(Fixture.from(Person.class).gimme("valid"));
            log.info("New Person: " + person.toString());
        });


    }
}

