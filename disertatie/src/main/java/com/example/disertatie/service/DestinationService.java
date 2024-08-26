package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Destination;
import com.example.disertatie.repo.DestinationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepo destinationRepo;

    @Autowired
    public DestinationService(DestinationRepo destinationRepo) {
        this.destinationRepo = destinationRepo;
    }

    public Destination addDestination(Destination destination){
        //destination.setName(UUID.randomUUID().toString());
        return destinationRepo.save(destination);
    }

    public List<Destination> findAllDestinations() {
        return destinationRepo.findAll();
    }

    public Destination updateDestination(Destination destination){
        return destinationRepo.save(destination);
    }

    public Destination findDestinationById(Long id){
        return destinationRepo.findDestinationById(id)
                .orElseThrow(() -> new UserNotFoundException("Destination by id " + id + " was not found"));
    }

    public void deleteDestination(Long id){
        destinationRepo.deleteDestinationById(id);

    }
}
