package com.rest.aurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.aurant.models.Distance;
import com.rest.aurant.models.Location;
import com.rest.aurant.repository.DistanceRepository;
import com.rest.aurant.repository.LocationRepository;

@Service
public class CharlieServices {
	@Autowired
	private DistanceServices distanceServices;
	
	
	
	public double areaOfTriangle1st() {
		Location B = DistanceRepository.nearAndFarRestaurant.get("Farthest").getEndLocation();
		Location C = DistanceRepository.nearAndFarRestaurant.get("Nearest").getEndLocation();
		double BC = distanceServices.compareStraightDistance(B, C);
		double AB = DistanceRepository.nearAndFarRestaurant.get("Farthest").getShortestDistance();
		double AC = DistanceRepository.nearAndFarRestaurant.get("Farthest").getShortestDistance();
		return findAreaOfTriangle(AB,AC,BC);
	}
	public double areaOfTriangle2nd() {
		Location B = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getEndLocation();
		Location C = DistanceRepository.nearAndFarRestaurantByCar.get("Nearest").getEndLocation();
		double BC = distanceServices.compareStraightDistance(B, C);
		double AB = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getCarDistance();
		double AC = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getCarDistance();
		return findAreaOfTriangle(AB,AC,BC);
	}
	
	
	private double findAreaOfTriangle(double AB, double AC, double BC) {
		double semi_perimeter = (AB+AC+BC)/2;
		double area = Math.sqrt(semi_perimeter*(semi_perimeter-AB)*(semi_perimeter-AC)*(semi_perimeter-BC));
		return area;
	}
	
	public double timeTakenToWalk1st(double speed) {
		Location B = DistanceRepository.nearAndFarRestaurant.get("Farthest").getEndLocation();
		Location C = DistanceRepository.nearAndFarRestaurant.get("Nearest").getEndLocation();
		double BC = distanceServices.compareStraightDistance(B, C);
		double AB = DistanceRepository.nearAndFarRestaurant.get("Farthest").getShortestDistance();
		double AC = DistanceRepository.nearAndFarRestaurant.get("Farthest").getShortestDistance();
		double perimeter = (AB+AC+BC);
		return perimeter/speed;
	}
	public double timeTakenToWalk2nd(double speed) {
		Location B = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getEndLocation();
		Location C = DistanceRepository.nearAndFarRestaurantByCar.get("Nearest").getEndLocation();
		double BC = distanceServices.compareStraightDistance(B, C);
		double AB = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getCarDistance();
		double AC = DistanceRepository.nearAndFarRestaurantByCar.get("Farthest").getCarDistance();
		double perimeter = (AB+AC+BC);
		return perimeter/speed;
	}
	
	

}
