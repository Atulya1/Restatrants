package com.rest.aurant.controller;



import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.aurant.ResponseClass;
import com.rest.aurant.services.CharlieServices;
import com.rest.aurant.services.DistanceServices;

@RestController
@RequestMapping("/getAnswers")
public class CharlieController {
	
	@Autowired
	private CharlieServices charlieServices;
	
	@GetMapping("/getArea")
	public ResponseClass getArea1st() {
		double status = charlieServices.areaOfTriangle1st();
		return new ResponseClass(200, "Area of traingle is "+status+" KM sq.");
	}
	
	@GetMapping("/getTime/{speed}")
	public ResponseClass getTime1st(@PathVariable double speed) {
		double status = charlieServices.timeTakenToWalk1st(speed);
		return new ResponseClass(200, "Time taken to walk at "+speed+" km/hr is "+status*60+" minutes");
	}
	
	@GetMapping("/getAreaByCar")
	public ResponseClass getArea2nd() {
		double status = charlieServices.areaOfTriangle2nd();
		return new ResponseClass(200, "Area of traingle is "+status+" KM sq.");
	}
	
	@GetMapping("/getTimeByCar/{speed}")
	public ResponseClass getTime2nd(@PathVariable double speed) {
		double status = charlieServices.timeTakenToWalk2nd(speed);
		return new ResponseClass(200, "Time taken to walk at "+speed+" km/hr is "+status*60+" minutes");
	}
}