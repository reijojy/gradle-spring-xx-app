package cradle.spring.xx.app;



import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import cradle.spring.xx.app.controller.HomeController;
import cradle.spring.xx.app.entity.Review;
import cradle.spring.xx.app.service.ReviewService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    private MockMvc mockMvc;

    @Autowired
    private HomeController controller;

    @Before
    public void beforeTest() {
        System.out.println("-----> BEFORE  <-----");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void contexLoads() throws Exception {
        // controller = null;

        assertThat(controller).isNotNull();
    }

    @Test
    public void homeControllerInitialTest() throws Exception {
        // This method is working as expected
        //MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/home"))
                .andExpect(status().isOk())
                //.andDo(print())
                .andExpect(content().string("Default one printing"));
    }
    @Test
    public void homeControllerParamTest() throws Exception {
        mockMvc.perform(get("/xxxx?id=1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().string("Id was passed to function receiveParm: 1"));
    }
  }
