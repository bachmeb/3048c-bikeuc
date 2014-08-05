package edu.uc.bikeuc.service;

import java.util.ArrayList;

import edu.uc.bikeuc.dto.BikeRoute;

public interface IBikeRouteService {

	/**
	 * @return ArrayList<BikeRoute>
	 * @throws Exception
	 */
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception;

	/**
	 * @param id
	 * @return BikeRoute
	 * @throws Exception
	 */
	public BikeRoute fetchRouteById(Integer id) throws Exception;

	/**
	 * @param lat
	 * @param lon
	 * @return BikeRoute
	 * @throws Exception
	 */
	public BikeRoute fetchNearestRoute(double lat, double lon) throws Exception;

	/**
	 * @param route
	 * @throws Exception
	 */
	public void save(BikeRoute route) throws Exception;
	
	/**
	 * @param none
	 * @throws Exception
	 */
	public String fetchPrime() throws Exception;
	
	/**
	 * @return none
	 * @throws Exception
	 */
	public BikeRoute fetchFirstRoute() throws Exception;
	
	

}