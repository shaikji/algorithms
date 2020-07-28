package com.jilani.ooad.ctci.parkinglot.practice;

public class Bus extends Vehicle {
	
	public Bus() {
		slotsNeeded = 5;
		vsize = VehicleSize.LARGE;
	}

	public boolean canFitInSpot(ParkingSpot ps) {
		if ( ps.size == VehicleSize.LARGE)
			return true;
		return false;
	}

	public void print() {
		System.out.print("B");
	}
}
