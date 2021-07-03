package com.rest.aurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurant.ResponseClass;
import com.rest.aurant.models.Location;
import com.rest.aurant.services.LocationServices;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationServices locationServices;
	
	@PostMapping("/saveMyLocation")
	public ResponseClass saveMyLocation(@RequestBody Location location) {
		String status = locationServices.saveMyLocation(location);
		return new ResponseClass(200,status);
	}
	
	@PostMapping("/saveNearByRestaurantLocation")
	public ResponseClass saveNearByRestaurantLocation(@RequestBody List<Location> locations) {
		String status = locationServices.saveRestaurantLocations(locations);
		return new ResponseClass(200,status);
	}
	
	@GetMapping("/getMyLocation")
	public ResponseClass saveMyLocation() {
		String status = locationServices.getMyLocation();
		return new ResponseClass(200,status);
	}
	
	@GetMapping("/getNearByRestaurantLocation")
	public ResponseClass getNearByRestaurantLocation() {
		String status = locationServices.getNearByRestaurants();
		return new ResponseClass(200,status);
	}
	

}
