package com.rest.aurant.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.rest.aurant.models.Distance;
import com.rest.aurant.models.Location;
import com.rest.aurant.repository.DistanceRepository;
import com.rest.aurant.repository.LocationRepository;
@Service
public class DistanceServices {
	
	public double compareStraightDistance(Location from, Location to) {
		double fromLatitude = Double.parseDouble(from.getLatitude());
		double fromLongitude = Double.parseDouble(from.getLongitude());
		double toLatitude = Double.parseDouble(to.getLatitude());
		double toLongitude = Double.parseDouble(to.getLongitude());
		double theta = fromLongitude - toLongitude;
		double distance = Math.sin(degreeToRadian(fromLatitude)) * Math.sin(degreeToRadian(toLatitude)) + Math.cos(degreeToRadian(fromLatitude)) * Math.cos(degreeToRadian(toLatitude)) * Math.cos(degreeToRadian(theta));
		distance = Math.acos(distance);
		distance = radianToDegree(distance);
		distance = distance * 60 * 1.1515;
		distance = distance * 1.609344; //changing from miles to kilometer
		return distance;
		
	}
	public double compareCarDistance(Location from, Location to) {
		return compareStraightDistance(from, to) + 1.5;
	}
	private double degreeToRadian(double deg) {
		  return (deg * Math.PI / 180.0);
	}
	private double radianToDegree(double rad) {
		  return (rad * 180.0 / Math.PI);
	}
	
	public void getDistanceBetweenMyLocationAndRestaurants() {
		for (Map.Entry<String, Location> location : LocationRepository.locations.entrySet()) {
	        Distance distance = new Distance(LocationRepository.myLocation,location.getValue(),this.compareCarDistance(LocationRepository.myLocation,location.getValue()),this.compareCarDistance(LocationRepository.myLocation,location.getValue()));
	        DistanceRepository.comparativeDistance.put(distance.getDistanceId(), distance);
	    }
	}
	
	public void getNearAndFarLocations() {
	}
}
