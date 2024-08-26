package com.example.disertatie.repo;

import com.example.disertatie.model.Trip;
import com.example.disertatie.model.User;
import com.example.disertatie.model.UserTripDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTripDetailsRepo extends JpaRepository<UserTripDetails, Long> {
    @Transactional

    List<UserTripDetails> findByTripId(Long tripId);
    Optional<UserTripDetails> findUserTripDetailsById(Long id);
    void deleteUserTripDetailsById(Long id);
}
