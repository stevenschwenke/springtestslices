package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Loads the whole application context and starts a web server.
 *
 * Startup time of context, according to Spring: 6.9, 6.8, 6.9
 * Lines in log: 51
 */
@SpringBootTest
class DudeControllerTest_SpringBootTest {

    @Autowired
    private DudeController dudeController;

    @Test
    void controllerCall() {
        dudeController.listPersons();
    }
}
