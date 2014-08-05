package edu.uc.bikeuc.dto;

public class BikeRack {

	private String rackName;  
    private double latitude;
    private double longitude;
    
    public BikeRack(){
    	//empty constructor
    }

    public BikeRack(double lat, double lon){
    	this.latitude = lat;
    	this.longitude = lon;
   
    }
    
    public BikeRack(double lat, double lon, String name){
    	this.latitude = lat;
    	this.longitude = lon;
    	this.rackName = name;
    }
        
    //getters and setters
    
	public String getRackName() {
		return rackName;
	}
	public void setRackName(String rackName) {
		this.rackName = rackName;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
