package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Loads only the persisting layer.
 *
 * Startup time of context, according to Spring: 5.1, 4.9, 4.9
 * Lines in log: 47 (until test itself starts)
 */
@DataJpaTest
public class Test_DataJpaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void testExample() {
        Person person = new Person();
        person.setName("Paul");
        this.entityManager.persist(person);
        Person reloadedPerson = personRepository.findAll().get(0);
        assertEquals("Paul", reloadedPerson.getName());
    }
}
