package com.ss.trip;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

@Id
@GeneratedValue
private Long id;

public Vehicle() {
}

public Vehicle(String licenseplace, String model, String status) {

	this.licensePlate = licenseplace;
	this.model = model;
	this.status = status;
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLicensePlate() {
	return licensePlate;
}
public void setLicensePlate(String licensePlate) {
	this.licensePlate = licensePlate;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String licensePlate;
private String model;
private String status;

}