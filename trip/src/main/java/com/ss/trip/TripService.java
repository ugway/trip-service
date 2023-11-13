package com.ss.trip;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TripService {
	
    @Autowired 
    private TripRepository tripRepository;
    
    public TripService() {
	}
    
	
	public Vehicle getVehicleDetails(long vehicleId) {
		String url = "http://localhost:8203/vehicles/"+vehicleId;
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		return template.exchange(url, HttpMethod.GET, entity ,Vehicle.class).getBody();
	}
	
	public Driver getDriverDetails(long driverId) {
		String url = "http://localhost:8201/drivers/"+driverId;
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
		return template.exchange(url, HttpMethod.GET, entity ,Driver.class).getBody();
	}
	
	public Trip createTrip(Trip trip) {
		return tripRepository.save(trip);
		
	}
	

}
