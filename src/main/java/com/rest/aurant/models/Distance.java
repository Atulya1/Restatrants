package com.rest.aurant.models;

import java.util.UUID;

public class Distance {
	
	private String distanceId;
	private Location beginningLocation;
	private Location endLocation;
	private double shortestDistance;
	private double carDistance;
	public Distance(Location beginningLocation, Location endLocation, double shortestDistance, double carDistance) {
		super();
		this.distanceId = UUID.randomUUID().toString();
		this.beginningLocation = beginningLocation;
		this.endLocation = endLocation;
		this.shortestDistance = shortestDistance;
		this.carDistance = carDistance;
	}
	public Distance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDistanceId() {
		return distanceId;
	}
	public Location getBeginningLocation() {
		return beginningLocation;
	}
	public void setBeginningLocation(Location beginningLocation) {
		this.beginningLocation = beginningLocation;
	}
	public Location getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	public double getShortestDistance() {
		return shortestDistance;
	}
	public void setShortestDistance(double shortestDistance) {
		this.shortestDistance = shortestDistance;
	}
	public double getCarDistance() {
		return carDistance;
	}
	public void setCarDistance(double carDistance) {
		this.carDistance = carDistance;
	}
	@Override
	public String toString() {
		return "Distance [beginningLocation=" + beginningLocation + ", endLocation=" + endLocation
				+ ", shortestDistance=" + shortestDistance + ", carDistance=" + carDistance + "]";
	}
	
}
