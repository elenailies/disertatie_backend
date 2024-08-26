package com.example.disertatie.repo;

import com.example.disertatie.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepo extends JpaRepository<Trip, Long> {

    Optional<Trip> findById(Long id);
    void deleteById(Long id);
}
