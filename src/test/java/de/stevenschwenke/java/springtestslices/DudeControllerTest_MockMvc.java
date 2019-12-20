package de.stevenschwenke.java.springtestslices;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Loads only the web layer.
 *
 * Startup time of context, according to Spring: 3.8, 3.7, 3.7
 * Lines in log: 38
 */
@WebMvcTest(DudeController.class)
class DudeControllerTest_MockMvc {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private DudeService dudeService;

    @Test
    void controllerReturnsOK() throws Exception {
        this.mockMvc.perform(get("/persons")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
