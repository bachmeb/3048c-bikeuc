package edu.uc.bikeuc.dto;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

/**
 * @author bbachmey
 * BikeRoute data transfer object
 */
public class BikeRoute {
	
	private int routeId;
	private ArrayList<LatLng> latlngs;
	
    
    /**
     * 
     */
    public BikeRoute(){
    	//empty constructor
    }
	/**
     */
    public BikeRoute(ArrayList<LatLng> latlngs){
    	this.latlngs = latlngs;
   
    }

    public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public ArrayList<LatLng> getLatlngs() {
		return latlngs;
	}

	public void setLatlngs(ArrayList<LatLng> latlngs) {
		this.latlngs = latlngs;
	}
    
}
