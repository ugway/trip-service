package com.ss.trip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Trip {

 @Id
 @GeneratedValue
 private Long id;
 
 public Trip() {
}

 public Trip(long vehicle2, long driver2, String string, String string2, String string3) {
	this.driver = driver2;
	this.vehicle = vehicle2;
	this.endLocation = string2;
	this.startLocation = string;
	this.status = string3;
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getStartLocation() {
	return startLocation;
}
public void setStartLocation(String startLocation) {
	this.startLocation = startLocation;
}
public long getVehicle() {
	return vehicle;
}

public void setVehicle(long vehicle) {
	this.vehicle = vehicle;
}

public long getDriver() {
	return driver;
}

public void setDriver(long driver) {
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

 private long vehicle;

 private long driver;

 private String startLocation;
 private String endLocation;
 private String status;

}

