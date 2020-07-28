package com.jilani.ooad.ctci.parkinglot.practice;


public class ParkingSpot {
	
	// Vehicle currently parked in this spot.
	Vehicle vehicle;
	
	// ParkingSpot size
	VehicleSize size;
	
	// spot Number
	int spotNumber;
	
	// Row number in this level
	int row;
	
	// Level to which this ParkingSpot belongs
	Level level;
	
	
	public ParkingSpot(int spotNumber, int row, VehicleSize vsize, Level lvl) {
		this.spotNumber = spotNumber;
		this.row = row;
		this.size = vsize;
		this.level = lvl;
	}
	

	// How do you tell the vehicle class to free the spot.
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	public boolean canFitVehicle (Vehicle v ) {
		if ( isAvailable() && v.canFitInSpot(this))
			return true;
		return false;
	}
	
	public boolean park( Vehicle v ) {
		
		if ( !canFitVehicle(v)) {
			return false;
		}
		
		vehicle = v;
		v.parkInSpot(this);
		return true;
	}
	

	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	public VehicleSize getSize() {
		return size;
	}
	
	public void print() {
		if ( vehicle == null) {
			
			if ( size == VehicleSize.LARGE)
				System.out.print("l");
			else if ( size == VehicleSize.COMPACT)
				System.out.println("c");
			else
				System.out.println("m");
		} else {
			vehicle.print();
		}
		
	}
}
