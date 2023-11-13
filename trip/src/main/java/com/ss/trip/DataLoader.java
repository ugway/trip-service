package com.ss.trip;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final TripRepository tripRepository;

    public DataLoader(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Trip trip1 = new Trip(1, 1, "Location A", "Location B", "In Progress");
        Trip trip2 = new Trip(2, 2, "Location C", "Location D", "Completed");
        Trip trip3 = new Trip(3, 3, "Location E", "Location F", "Scheduled");
        tripRepository.saveAll(List.of(trip1, trip2, trip3));
    }
}
