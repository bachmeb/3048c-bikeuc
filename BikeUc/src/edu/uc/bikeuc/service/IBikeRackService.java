package edu.uc.bikeuc.service;

import java.util.ArrayList;

import edu.uc.bikeuc.dto.BikeRack;

public interface IBikeRackService {

	/**
	 * @return ArrayList<BikeRack>
	 * @throws Exception
	 */
	public ArrayList<BikeRack> fetchAllRacks() throws Exception;

	/**
	 * @param id
	 * @return BikeRack
	 * @throws Exception
	 */
	public BikeRack fetchRackById(Integer id) throws Exception;

	/**
	 * @param lat
	 * @param lon
	 * @return BikeRack
	 * @throws Exception
	 */
	public BikeRack fetchNearestRack(double lat, double lon) throws Exception;

	/**
	 * @param rack
	 * @throws Exception
	 */
	public void save(BikeRack rack) throws Exception;
	
	/**
	 * @param none
	 * @throws Exception
	 */
	public String fetchPrime() throws Exception;
	
	/**
	 * @return none
	 * @throws Exception
	 */
	public BikeRack fetchFirstRack() throws Exception;
	
	

}