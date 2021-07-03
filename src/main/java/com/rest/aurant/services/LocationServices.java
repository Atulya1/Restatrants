package com.rest.aurant.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.rest.aurant.models.Location;
import com.rest.aurant.repository.LocationRepository;

@Service
public class LocationServices {
	
	public String saveMyLocation(Location location) {
		LocationRepository.myLocation = new Location(location.getLocationName(),location.getLatitude(),location.getLongitude(),location.getCountry(),location.getCity());
		//LocationRepository.locations.put(myLocation.getLocationId(), myLocation);
		return "My Current Location added";
		
	}
	public String getMyLocation() {
		return LocationRepository.myLocation.toString();
	}
	public String saveRestaurantLocations(List<Location> locations) {
		for(Location location : locations) {
			Location restaurantLocations = new Location(location.getLocationName(),location.getLatitude(),location.getLongitude(),location.getCountry(),location.getCity());
			LocationRepository.locations.put(restaurantLocations.getLocationId(),restaurantLocations);
		}
		return "Restaurant locations added";
		
	}
	public String getNearByRestaurants() {
		return LocationRepository.locations.toString();
	}
	
}
