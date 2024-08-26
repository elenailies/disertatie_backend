package com.example.disertatie.resource;

import com.example.disertatie.model.Destination;
import com.example.disertatie.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/destination")
public class DestinationResource {

    private final DestinationService destinationService;

    public DestinationResource(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Destination>> getAllDestinations (){
        List <Destination> destinations = destinationService.findAllDestinations();
        return new ResponseEntity<>(destinations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Destination> getDestinationById (@PathVariable("id") Long id){
        Destination destination = destinationService.findDestinationById(id);
        return new ResponseEntity<>(destination, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Destination> addDestination(@RequestBody Destination destination){
        Destination newDestination = destinationService.addDestination(destination);
        return new ResponseEntity<>(newDestination, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Destination> updateDestination(@RequestBody Destination destination){
        Destination updateDestination = destinationService.updateDestination(destination);
        return new ResponseEntity<>(updateDestination, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDestination(@PathVariable("id") Long id){
        destinationService.deleteDestination(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
