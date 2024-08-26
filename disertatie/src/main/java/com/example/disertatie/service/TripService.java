package com.example.disertatie.service;

import com.example.disertatie.model.Trip;
import com.example.disertatie.repo.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    private final TripRepo tripRepo;

    @Autowired
    public TripService(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    public Trip addTrip(Trip trip){
        return tripRepo.save(trip);
    }

    public List<Trip> findAllTrips() {
        return tripRepo.findAll();
    }

    public Trip updateTrip(Trip trip){
        return tripRepo.save(trip);
    }

    public Trip findTripById(Long id){
        return tripRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip by id " + id + " was not found"));
    }

    public void deleteTrip(Long id){
        tripRepo.deleteById(id);
    }
}
