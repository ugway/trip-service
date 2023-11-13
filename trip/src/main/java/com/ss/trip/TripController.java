package com.ss.trip;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trips")
public class TripController {

 @Autowired
 private TripRepository tripRepository;
 
 @Autowired
 private TripService service;
 

 @GetMapping
 public List<Trip> getAllTrips() {
     return tripRepository.findAll();
 }

 @GetMapping("/{tripId}")
 public ResponseEntity<Trip> getTrip(@PathVariable Long tripId) {
     Optional<Trip> trip = tripRepository.findById(tripId);
     return trip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
 }
 
 
 @GetMapping("/loc/{tripId}")
 public ResponseEntity<CustomerTrip> getTripLocation(@PathVariable Long tripId) {
     Optional<Trip> trip = tripRepository.findById(tripId);
     if(null!=trip) {
    	 Optional<CustomerTrip> cTrip = Optional.of(new CustomerTrip(trip.get()));
    	 return cTrip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
     }
     return ResponseEntity.notFound().build();
 }
 
 @PostMapping("/trip")
 public ResponseEntity<CustomerTrip> createTrip(@RequestBody Trip trip){
	 Trip savedTrip = service.createTrip(trip);
	 Optional<CustomerTrip> cTrip = Optional.of(new CustomerTrip(savedTrip));
	 return cTrip.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 
 }
}

