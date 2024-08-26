package com.example.disertatie.resource;

import com.example.disertatie.model.Category;
import com.example.disertatie.model.User;
import com.example.disertatie.model.Trip;
import com.example.disertatie.model.UserTripDetails;
import com.example.disertatie.service.TripService;
import com.example.disertatie.service.UserService;
import com.example.disertatie.service.UserTripDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/bookings")
public class UserTripDetailsResource {

    private final UserTripDetailsService userTripDetailsService;
    private final UserService userService; // Assuming UserService exists
    private final TripService tripService; // Assuming TripService exists

    @Autowired
    public UserTripDetailsResource(UserTripDetailsService userTripDetailsService, UserService userService, TripService tripService) {
        this.userTripDetailsService = userTripDetailsService;
        this.userService = userService;
        this.tripService = tripService;
    }

    @PostMapping("/book")
    public UserTripDetails bookTrip(@RequestParam Long userId, @RequestParam Long tripId, @RequestParam String bookingDate) {
        User user = userService.findUserById(userId);
        Trip trip = tripService.findTripById(tripId);
        return userTripDetailsService.bookTrip(user, trip, bookingDate);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserTripDetails>> getAllUserTripDetails (){
        List <UserTripDetails> userTripDetails = userTripDetailsService.findAllUserTripDetails();
        return new ResponseEntity<>(userTripDetails, HttpStatus.OK);
    }


    @GetMapping("/trip/{tripId}")
    public List<UserTripDetails> getTripUsers(@PathVariable Long tripId) {
        return userTripDetailsService.getUsersByTrip(tripId);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId) {
        userTripDetailsService.cancelBooking(bookingId);
    }
}
