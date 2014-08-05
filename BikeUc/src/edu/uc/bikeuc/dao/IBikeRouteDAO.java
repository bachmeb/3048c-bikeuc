package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.database.Cursor;
import edu.uc.bikeuc.dto.BikeRoute;

public interface IBikeRouteDAO {

	public void save(BikeRoute rack) throws Exception;
	
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception;
	
	public BikeRoute populateRouteFromCursor(Cursor c);
	
	public BikeRoute fetchRouteById(Integer id) throws Exception;

	public BikeRoute fetchNearestRoute(double lat, double lon)throws Exception;
	
	public String fetchPrime() throws Exception;

	public BikeRoute fetchFirstRoute() throws Exception;
	
	
}