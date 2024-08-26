package com.example.disertatie.repo;

import com.example.disertatie.model.Destination;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinationRepo extends JpaRepository<Destination, Long> {

    @Transactional
    void deleteDestinationById(Long id);

    Optional<Destination> findDestinationById(Long id);
}
