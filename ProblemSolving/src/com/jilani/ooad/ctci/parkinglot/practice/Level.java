package com.jilani.ooad.ctci.parkinglot.practice;

public class Level {
	
	int floor;
	ParkingSpot[] spots;
	int availableSpots=0;
	int SPOTS_PER_ROW = 10;
	
	// Initialize a Level/Floor with a number and spots
	public Level(int flrNo, int numberOfSpots) {
		
		this.floor = flrNo;
		spots = new ParkingSpot[numberOfSpots];
		
		int largeSpots = numberOfSpots/4;
		int bikeSpots = numberOfSpots/4;
		int compactSpots = numberOfSpots - largeSpots - bikeSpots;
		
		for ( int i=0; i< numberOfSpots; i++) {
			
			VehicleSize vsize = VehicleSize.MOTORCYCLE;
			if ( i < largeSpots)
				vsize = VehicleSize.LARGE;
			else if ( i < largeSpots + compactSpots) 
				vsize = VehicleSize.COMPACT;
			
			int row = i / SPOTS_PER_ROW;
			
			spots[i] = new ParkingSpot(i, row, vsize, this);
			
		}
		availableSpots = numberOfSpots;
	}
	
	public int availableSpots () {
		return availableSpots;
	}
	
	public boolean parkVehicle(Vehicle v) {
		
		if ( availableSpots < v.getSlotsNeeded())
			return false;
		
		int spotNumber = findAvailableSpots(v);
		
		if ( spotNumber < 0 )
			return false;
		
		return parkStartingAtSpot(spotNumber, v);
	}
	
	boolean parkStartingAtSpot( int spotNumber, Vehicle v) {
		
		v.clearSpots();
		boolean success = true;
		
		for ( int i=0; i < v.getSlotsNeeded(); i++) {
			
			if ( !spots[i+spotNumber].park(v) )
				return false;
		}
		
		availableSpots -= v.getSlotsNeeded();
		return true;
	}
	
	int findAvailableSpots(Vehicle v) {
		
		int needed = v.getSlotsNeeded();
		
		int lastRow = -1;
		int spotsFound = 0;
		
		for ( int i=0; i< spots.length; i++) {
			
			ParkingSpot spot = spots[i];
			
			if ( lastRow != spot.row) {
				lastRow = spot.row;
				spotsFound = 0;
			}
			
			if ( spot.canFitVehicle(v)) {
				spotsFound++;
			}
			
			if ( spotsFound == needed) {
				return i - (spotsFound-1);
			}
		}
		
		return -1;
	}
	
	public void print() {
		int lastRow = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spot.getRow() != lastRow) {
				System.out.print("  ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
	
	/* When a car was removed from the spot, increment availableSpots */
	public void spotFreed() {
		availableSpots++;
	}
}

	
	
	
