package going.model.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@SpringBootTest
class SearchControllerTest {

    private MockMvc mvc;

    @LocalServerPort
    private int port = 8090;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void serUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void mainPage() throws Exception {
        int page = 1;
        String url = "http://localhost:" + port + "/search/main?page=" + page;

        mvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}