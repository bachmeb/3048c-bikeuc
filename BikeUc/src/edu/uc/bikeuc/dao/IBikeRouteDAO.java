package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import edu.uc.bikeuc.dto.BikeRoute;

public interface IBikeRouteDAO {

	ArrayList<BikeRoute> fetchAllRoutes() throws Exception;

	BikeRoute fetchRouteById(Integer id) throws Exception;

	BikeRoute fetchNearestRoute(double lat, double lon) throws Exception;

	void save(BikeRoute route) throws Exception;

}
