package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Loads the whole application context without starting a web server. However, a TestDispatcherServlet is created, which causes the log to be slightly longer than the pure @SpringBootTest-version.
 *
 * Startup time of context, according to Spring: 7.31, 7.5, 7.6
 * Lines in log: 54
 */
@SpringBootTest
@AutoConfigureMockMvc
class DudeControllerTest_SpringBootTest_AutoConfigureMockMvc {

    @Autowired
    private DudeController dudeController;

    @Test
    void controllerCall() {
        dudeController.listPersons();
    }
}
