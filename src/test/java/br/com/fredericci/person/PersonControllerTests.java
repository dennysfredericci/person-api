package br.com.fredericci.person;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.com.fredericci.person.controller.PersonController;
import br.com.fredericci.person.exception.NotFoundException;
import br.com.fredericci.person.model.Person;
import br.com.fredericci.person.service.PersonService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.UUID;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonContractApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class PersonControllerTests {


    private final PersonService personService = mock(PersonService.class);

    private final PersonController personController = new PersonController(personService);


    @Before
    public void setup() {

        final UUID id = UUID.fromString("997c383e-c87c-4ded-b96c-778dd382311d");

        when(personService.findById(id.toString())).thenReturn(Person.builder().id(id).name("Dennys").surname("Fredericci").build());
        when(personService.findById("581100ce-d495-45f7-967c-2a129b96b3a5")).thenThrow(NotFoundException.class);

        RestAssuredMockMvc.standaloneSetup(this.personController);
    }


}
