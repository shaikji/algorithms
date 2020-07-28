package com.jilani.ooad.ctci.parkinglot.practice;

public class Car extends Vehicle {
	
	public Car() {
		slotsNeeded = 1;
		vsize = VehicleSize.COMPACT;
	}

	public boolean canFitInSpot(ParkingSpot ps) {
		if ( ps.size == VehicleSize.LARGE || ps.size == VehicleSize.COMPACT)
			return true;
		return false;
	}
	
	public void print() {
		System.out.print("C");
	}
}
