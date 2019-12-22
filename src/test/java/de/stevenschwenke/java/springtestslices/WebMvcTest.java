package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Loads only the web layer.
 * <p>
 * Startup time of context, according to Spring: 3.8, 3.7, 3.7
 * Lines in log: 38
 */
@org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest(PersonController.class)
class WebMvcTest {

    @Autowired
    MockMvc mockMvc;

    // This service has to be mocked here, even when it is not used in the test. Using @WebMvcTest, only the specified
    // controller is created by Spring, not its dependencies. This is why they have to be provided here, as mock.
    @MockBean
    private PersonService personService;

    @Test
    void controllerReturnsOK() throws Exception {
        this.mockMvc.perform(get("/persons")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
