package com.ss.trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerTrip {

 @Autowired 
 private TripService service;
 private Long tripId;
 
 public CustomerTrip() {
}

 public CustomerTrip(Trip trip) {
	 this.tripId = trip.getId();
	 this.driver = new TripService().getDriverDetails(trip.getDriver());
	 this.vehicle = new TripService().getVehicleDetails(trip.getVehicle());
	 this.startLocation = trip.getStartLocation();
	 this.endLocation = trip.getEndLocation();
	 this.status = trip.getStatus();
	
}
public Long getTripId() {
	return tripId;
}
public void setTripId(Long id) {
	this.tripId = id;
}

public String getStartLocation() {
	return startLocation;
}
public void setStartLocation(String startLocation) {
	this.startLocation = startLocation;
}




public void setService(TripService service) {
	this.service = service;
}

public Vehicle getVehicle() {
	return vehicle;
}

public void setVehicle(Vehicle vehicle) {
	this.vehicle = vehicle;
}

public Driver getDriver() {
	return driver;
}

public void setDriver(Driver driver) {
	this.driver = driver;
}

public String getEndLocation() {
	return endLocation;
}

public void setEndLocation(String endLocation) {
	this.endLocation = endLocation;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}


private Vehicle vehicle;

 private Driver driver;

 private String startLocation;
 private String endLocation;
 private String status;

}

