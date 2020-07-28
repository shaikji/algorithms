package com.jilani.ooad.ctci.parkinglot.practice;

import java.util.ArrayList;

public abstract class Vehicle {

	// Vehicle has a license plate
	String licensePlate;
	
	// Let implementations decide the vehicle size and slots needed
	VehicleSize vsize;
	int slotsNeeded;
	
	ArrayList<ParkingSpot> listOfSpots = 
			new ArrayList<ParkingSpot>();
	
	public abstract boolean canFitInSpot(ParkingSpot ps);
	
	public int getSlotsNeeded() {
		return slotsNeeded;
	}
	
	public void parkInSpot(ParkingSpot ps) {
		listOfSpots.add(ps);
	}
	
	public void clearSpots() {
		for ( int i=0; i < listOfSpots.size();i++) {
			listOfSpots.get(i).removeVehicle();
		}
		
		listOfSpots.clear();
	}
	
	public abstract void print();
}
