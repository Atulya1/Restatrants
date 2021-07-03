package com.rest.aurant.models;

import java.util.Comparator;

public class CompareDistanceByCar implements Comparator<Distance>{

	@Override
	public int compare(Distance o1, Distance o2) {
		if(o1.getCarDistance() == o2.getCarDistance())  
			return 0;  
		else if(o1.getCarDistance() > o2.getCarDistance())  
			return 1;  
		else  
			return -1;  
	}

}
