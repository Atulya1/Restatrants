package com.rest.aurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurant.ResponseClass;
import com.rest.aurant.services.DistanceServices;

@RestController
@RequestMapping("/distance")
public class DistanceController {
	
	@Autowired
	private DistanceServices distanceServices;
	
	@GetMapping("/getAllRestaurantNearBy")
	public ResponseClass getAllRestaurantNearBy() {
		String status = distanceServices.getDistanceBetweenMyLocationAndRestaurants();
		return new ResponseClass(200, status);
	}
	
	@GetMapping("/getNearestAndFarthestRestaurant")
	public ResponseClass getNearestAndFarthestRestaurant() {
		String status = distanceServices.getShortestNearAndFarLocations();
		return new ResponseClass(200, status);
	}
	
	@GetMapping("/getNearestAndFarthestRestaurantByCar")
	public ResponseClass getNearestAndFarthestRestaurantByCar() {
		String status = distanceServices.getNearestAndFarthestRestaurantByCar();
		return new ResponseClass(200, status);
	}

}
