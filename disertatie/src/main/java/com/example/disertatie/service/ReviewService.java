package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Review;
import com.example.disertatie.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public Review addReview(Review review){
        //review.setName(UUID.randomUUID().toString());
        return reviewRepo.save(review);
    }

    public List<Review> findAllReviews() {
        return reviewRepo.findAll();
    }

    public Review updateReview(Review review){
        return reviewRepo.save(review);
    }

    public Review findReviewById(Long id){
        return reviewRepo.findReviewById(id)
                .orElseThrow(() -> new UserNotFoundException("Review by id " + id + " was not found"));
    }

    public void deleteReview(Long id){
        reviewRepo.deleteReviewById(id);

    }

}
