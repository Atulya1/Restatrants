package com.rest.aurant.models;

import java.util.UUID;

public class Location {
	private String locationId;
	private String locationName;
	private String latitude;
	private String longitude;
	private String country;
	private String city;
	
	public Location(String locationName, String latitude, String longitude, String country, String city) {
		super();
		this.locationId = UUID.randomUUID().toString();
		this.locationName = locationName;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.city = city;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLocationId() {
		return locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", country=" + country + ", city=" + city + "]";
	}
	
	

}
