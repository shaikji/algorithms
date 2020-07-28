package com.jilani.ooad.ctci.parkinglot.practice;

public class Motorcycle extends Vehicle {
	
	public Motorcycle() {
		slotsNeeded = 1;
		vsize = VehicleSize.MOTORCYCLE;
	}

	public boolean canFitInSpot(ParkingSpot ps) {
		if ( ps.size == VehicleSize.LARGE || ps.size == VehicleSize.COMPACT || ps.size == VehicleSize.MOTORCYCLE)
			return true;
		return false;
	}
	
	public void print() {
		System.out.print("M");
	}
}
