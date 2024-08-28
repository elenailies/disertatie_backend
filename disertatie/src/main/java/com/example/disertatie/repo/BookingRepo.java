package com.example.disertatie.repo;

import com.example.disertatie.model.Booking;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    @Transactional
    void deleteBookingById(Long id);

    Optional<Booking> findBookingById(Long id);

}
