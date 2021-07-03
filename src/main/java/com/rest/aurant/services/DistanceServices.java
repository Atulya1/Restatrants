package com.rest.aurant.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.rest.aurant.models.CompareDistanceByCar;
import com.rest.aurant.models.Distance;
import com.rest.aurant.models.Location;
import com.rest.aurant.repository.DistanceRepository;
import com.rest.aurant.repository.LocationRepository;
@Service
public class DistanceServices {
	Random random = new Random();
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
	private double compareCarDistance(Location from, Location to) {
		return compareStraightDistance(from, to) + random.nextInt(2);
	}
	private double degreeToRadian(double deg) {
		  return (deg * Math.PI / 180.0);
	}
	private double radianToDegree(double rad) {
		  return (rad * 180.0 / Math.PI);
	}
	
	public String getDistanceBetweenMyLocationAndRestaurants() {
		for (Map.Entry<String, Location> location : LocationRepository.locations.entrySet()) {
	        Distance distance = new Distance(LocationRepository.myLocation,location.getValue(),compareStraightDistance(LocationRepository.myLocation,location.getValue()),compareCarDistance(LocationRepository.myLocation,location.getValue()));
	   
	        DistanceRepository.comparativeDistance.putIfAbsent(location.getKey(), distance);
	    }
		return getRestaurantByShortestDistance().toString();
	}
	
	public String getShortestNearAndFarLocations() {
		getDistanceBetweenMyLocationAndRestaurants();
		DistanceRepository.nearAndFarRestaurant.put("Nearest", getRestaurantByShortestDistance().get(0));
		DistanceRepository.nearAndFarRestaurant.put("Farthest", getRestaurantByShortestDistance().get(getRestaurantByShortestDistance().size()-1));
		return DistanceRepository.nearAndFarRestaurant.toString();
		
	}
	public String getNearestAndFarthestRestaurantByCar() {
		getDistanceBetweenMyLocationAndRestaurants();
		DistanceRepository.nearAndFarRestaurantByCar.put("Nearest", getRestaurantByCarDistance().get(0));
		DistanceRepository.nearAndFarRestaurantByCar.put("Farthest", getRestaurantByCarDistance().get(getRestaurantByCarDistance().size()-1));
		return DistanceRepository.nearAndFarRestaurantByCar.toString();
		
	}
	private List<Distance> getRestaurantByShortestDistance() {
		List<Distance> distance = new ArrayList<>();
		for (Map.Entry<String, Distance> d : DistanceRepository.comparativeDistance.entrySet()) {
			distance.add(d.getValue());
		}
		Collections.sort(distance);
		return distance;
	}
	private List<Distance> getRestaurantByCarDistance() {
		List<Distance> distance = new ArrayList<>();
		for (Map.Entry<String, Distance> d : DistanceRepository.comparativeDistance.entrySet()) {
			distance.add(d.getValue());
		}
		
		Collections.sort(distance, new CompareDistanceByCar());
		return distance;
	}
}
