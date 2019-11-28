package cradle.spring.xx.app.service;

import cradle.spring.xx.app.entity.Review;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ReviewServiceImpl implements ReviewService {

    public Review createReview(Review review) {

        Review newReview = new Review("Comment X");
        newReview.setId(new Random().nextInt());
        System.out.println(newReview.toString());
        return newReview;
    }
}
