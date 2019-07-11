package br.com.fredericci.person;

import br.com.fredericci.person.controller.PersonController;
import br.com.fredericci.person.exception.NotFoundException;
import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.service.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonContractApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class PersonControllerTests {


    private final PersonService personService = mock(PersonService.class);

    private final PersonController personController = new PersonController(personService);


    @Before
    public void setup() {

        when(personService.findById(1L)).thenReturn(Person.builder().id(1L).name("Dennys").surname("Fredericci").build());
        when(personService.findById(2L)).thenThrow(NotFoundException.class);

        RestAssuredMockMvc.standaloneSetup(this.personController);
    }


}
