package br.com.fredericci.person.controller;

import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Page<Person> findAll(@RequestParam(name = "pageNumber", defaultValue = "1") int page,
                                @RequestParam(name = "pageSize", defaultValue = "10") int size) {
        return this.personService.findAll(PageRequest.of(page, size));
    }


    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    public Person get(@PathVariable Long personId) {
        return this.personService.findById(personId);
    }


    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public void create(Person person) {
        this.personService.create(person);
    }



}
