package com.example.disertatie.resource;

import com.example.disertatie.model.Trip;
import com.example.disertatie.service.TripService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/trip")
public class TripResource {

    private final TripService tripService;

    public TripResource(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Trip>> getAllTrips(){
        List<Trip> trips = tripService.findAllTrips();
        return new ResponseEntity<>(trips, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable("id") Long id){
        Trip trip = tripService.findTripById(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Trip> addTrip(@RequestBody Trip trip){
        Trip newTrip = tripService.addTrip(trip);
        return new ResponseEntity<>(newTrip, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Trip> updateTrip(@RequestBody Trip trip){
        Trip updatedTrip = tripService.updateTrip(trip);
        return new ResponseEntity<>(updatedTrip, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTrip(@PathVariable("id") Long id){
        tripService.deleteTrip(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
