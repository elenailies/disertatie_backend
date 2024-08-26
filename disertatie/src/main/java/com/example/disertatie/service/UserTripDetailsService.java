package com.example.disertatie.service;

import com.example.disertatie.exception.BookingNotFoundException;
import com.example.disertatie.model.Category;
import com.example.disertatie.model.User;
import com.example.disertatie.model.Trip;
import com.example.disertatie.model.UserTripDetails;
import com.example.disertatie.repo.UserTripDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTripDetailsService {

    private final UserTripDetailsRepo userTripDetailsRepository;

    @Autowired
    public UserTripDetailsService(UserTripDetailsRepo userTripDetailsRepository) {
        this.userTripDetailsRepository = userTripDetailsRepository;
    }

    public UserTripDetails bookTrip(User user, Trip trip, String bookingDate) {
        UserTripDetails userTripDetails = new UserTripDetails(user, trip, bookingDate);
        return userTripDetailsRepository.save(userTripDetails);
    }

    public List<UserTripDetails> findAllUserTripDetails() {
        return userTripDetailsRepository.findAll();
    }

    public List<UserTripDetails> getUsersByTrip(Long tripId) {
        return userTripDetailsRepository.findByTripId(tripId);
    }

    public void cancelBooking(Long bookingId) {
        UserTripDetails booking = userTripDetailsRepository.findById(bookingId)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + bookingId + " was not found"));

        userTripDetailsRepository.delete(booking);
    }

}
