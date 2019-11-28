package cradle.spring.xx.app;

import cradle.spring.xx.app.service.InsructorServiceStub;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class InstructorDirectTest {

    @Autowired
    private InsructorServiceStub instructorServiceStub;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        System.out.println("=======> BEFORE  <=======");
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    @Test
    public void testInstructorCourseList(int theid) {
        //InsructorServiceStub.
    }
}
