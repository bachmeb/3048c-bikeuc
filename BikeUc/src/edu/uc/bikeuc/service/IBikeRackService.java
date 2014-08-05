package edu.uc.bikeuc.service;

import java.util.ArrayList;

import edu.uc.bikeuc.dto.BikeRack;

public interface IBikeRackService {

	/**
	 * @return ArrayList<BikeRack>
	 * @throws Exception
	 */
	public abstract ArrayList<BikeRack> fetchAllRacks() throws Exception;

	/**
	 * @param id
	 * @return BikeRack
	 * @throws Exception
	 */
	public abstract BikeRack fetchRackById(Integer id) throws Exception;

	/**
	 * @param lat
	 * @param lon
	 * @return BikeRack
	 * @throws Exception
	 */
	public abstract BikeRack fetchNearestRack(double lat, double lon) throws Exception;
	
	/**
	 * @param rack
	 * @throws Exception
	 */
	public abstract void save(BikeRack rack) throws Exception;

}