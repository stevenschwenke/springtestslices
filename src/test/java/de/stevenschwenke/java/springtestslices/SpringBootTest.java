package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Loads the whole application context and starts a web server.
 * <p>
 * Startup time of context, according to Spring: 6.9, 6.8, 6.9
 * Lines in log: 51
 */
@org.springframework.boot.test.context.SpringBootTest
class SpringBootTest {

    @Autowired
    private PersonController personController;

    @Test
    void controllerCall() {
        personController.listPersons();
    }
}
