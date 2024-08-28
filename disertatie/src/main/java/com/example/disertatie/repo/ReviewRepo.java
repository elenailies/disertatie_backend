package com.example.disertatie.repo;

import com.example.disertatie.model.Category;
import com.example.disertatie.model.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Transactional
    void deleteReviewById(Long id);

    Optional<Review> findReviewById(Long id);

}
