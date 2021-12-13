package com.example.springtemplate.daos;

import com.example.springtemplate.models.Bookings;
import com.example.springtemplate.models.Review;
import com.example.springtemplate.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReviewRestOrmDao {
    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/api/reviews")
    public List<Review> findAllReviews() {
        return reviewRepository.findAllReviews();
    }

//    @GetMapping("/api/reviews/{guestId}")
//    public List<Review> findReviewsByGuestById(
//            @PathVariable("guestId") Integer id) {
//        return reviewRepository.findReviewForGuestsById(id);
//    }

    @GetMapping("/api/reviews/{reviewId}")
    public Review findReviewById(
            @PathVariable("reviewId") Integer id) {
        return reviewRepository.findReviewById(id);
    }
    @PostMapping("/api/reviews")
    public Review createReview(@RequestBody Review review) {
        return reviewRepository.save(review);
    }

    @PutMapping("/api/reviews/{reviewId}")
    public Review updateGuest(
            @PathVariable("reviewId") Integer id,
            @RequestBody Review reviewUpdates) {
        Review review = reviewRepository.findReviewById(id);
        review.setLikes(reviewUpdates.getLikes());
        review.setComments(reviewUpdates.getComments());
        review.setGuest(reviewUpdates.getGuest());
        review.setHotels(reviewUpdates.getHotel());

        return reviewRepository.save(review);
    }

    @DeleteMapping("/api/reviews/{reviewId}")
    public void deleteReview(
            @PathVariable("reviewId") Integer id) {
        reviewRepository.deleteById(id);
    }
}
