package edu.uc.bikeuc.dto;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

/**
 * @author bbachmey
 * BikeRoute data transfer object
 */
public class BikeRoute {


	private int routeId;
	private String routeName;
	private ArrayList<LatLng> latlngs;
	  
    /**
     * 
     */
    public BikeRoute(){
    	//empty constructor
    }
	/**
     */
    public BikeRoute(String name, ArrayList<LatLng> latlngs){
    	this.routeName = name;
    	this.latlngs = latlngs;
   
    }

    public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String rname) {
		this.routeName = rname;
	}
	
	public ArrayList<LatLng> getLatlngs() {
		return latlngs;
	}

	public void setLatlngs(ArrayList<LatLng> latlngs) {
		this.latlngs = latlngs;
	}
    
}
