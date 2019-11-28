package cradle.spring.xx.app;

import cradle.spring.xx.app.entity.Review;
import cradle.spring.xx.app.service.ReviewService;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewTest {

    @Autowired
    private ReviewService reviewService;

    private MockMvc mockMvc;

    @Before
    public void beforeTest() {
        System.out.println("-----> BEFORE  <-----");
        mockMvc = MockMvcBuilders.standaloneSetup(reviewService).build();
    }

    @Test
    public void reviewClassTest() throws Exception {
        Review review = new Review("Fine Course");
        review.setId(101);
        //assertNotNull("Review comment isn't null", reviewService.createReview(review).getComment());
        //assertNotEquals("Comment Y", reviewService.createReview(review).getComment());
        assertEquals(review.getComment(), reviewService.createReview(review).getComment());
    }
    @Test
    public void reviewSecondTest() throws Exception {
        Review review = new Review("Fine Course");
        review.setId(101);
        Review tempReview = reviewService.createReview(review);
        if (tempReview != null) {
            System.out.println(getClass().getName() + " Testmethon reviewSecontTest: " + tempReview.toString());
            assertThat(tempReview, instanceOf(Review.class));
        }
    }
    @AfterClass
    public static void afterTest() {
        System.out.println("-----> DESTROY <-----");
    }
}
/*    @Test
    public void getContextServerUrl_shouldFind() throws Exception {
        final String expectedId = "INTERNAL";
        final String expectedUrl = "http://una-context-server:8030/cm";
        persistWhitelist(expectedId, expectedUrl, true);
        getContextServerUrl(expectedId)
                .andDo(print())
                .andExpect(status().isOk());
    }*/

