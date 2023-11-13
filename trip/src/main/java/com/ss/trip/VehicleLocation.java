package com.ss.trip;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VehicleLocation {



	 @Id
	 @GeneratedValue
	 private Long tripId;
	 
	 public VehicleLocation() {
	}

	 public VehicleLocation(Long tripId) {
		this.tripId = tripId;
	
	}
	 
	 String longitude;
	 String latitude;

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
