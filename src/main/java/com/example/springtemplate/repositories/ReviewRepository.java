package com.example.springtemplate.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.springtemplate.models.Review;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,Integer> {
//    @Query(value="SELECT review FROM Review review where review.guest.id=:guestId",nativeQuery = true)
//    List<Review> findReviewForGuestsById(@Param("guestId")int guestId);

    @Query("SELECT review FROM Review review where review.hotels1.id=:hotelId")
    List<Review> findReviewForHotelById(@Param("hotelId")int hotelId);


    @Query(value="SELECT * from Review",nativeQuery = true)
    List<Review> findAllReviews();

    @Query(value = "SELECT * FROM Review WHERE id=:reviewId",
            nativeQuery = true)
    public Review findReviewById(@Param("reviewId") Integer id);

}
