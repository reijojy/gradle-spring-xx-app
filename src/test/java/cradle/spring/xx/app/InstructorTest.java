package cradle.spring.xx.app;

import cradle.spring.xx.app.controller.TestController;
import cradle.spring.xx.app.service.InstructorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorTest {

    @Autowired
    private TestController controller;


   /* @Autowired
    private InstructorService instructorService; */

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        System.out.println("=======> BEFORE  <=======");
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

   @Test
    public void getInstructorByIdTest() throws Exception {
        Integer id = 1;
        mockMvc.perform(get("/instructor/byid?InstructorId=1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
        //  getInstructorById(@RequestParam("InstructorId")
       // .param("InstructorId", String.valueOf(theInstructorId)))
    }
    @Test
    public void getInstructorLastName() throws Exception {

        mockMvc.perform(get("/instructor/getLastName?InstructorId=1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Sörsselsson"));
    }
    @Test
    public void getInstructorCourseCount() throws Exception {
        mockMvc.perform(get("/instructor/getCourseCount?InstructorId=1"))
                .andExpect(status().isOk());
                //.andExpect(content().string());
    }
    @Test
    public void getAllInstructorsTest() throws Exception {

        // The test run worked without the url method having @ResponseBody
        // if just returning a string, but as returning a more complex objet fails
        // with assert error
        mockMvc.perform(get("/instructor/allinstructors"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
                //.andDo(print());
                //.andExpect(content().string("Hello from getAllInstructors"));
    }
}
