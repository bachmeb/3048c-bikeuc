package edu.uc.bikeuc.service;

import java.util.ArrayList;

import android.content.Context;

import edu.uc.bikeuc.dao.BikeRackDAO;
import edu.uc.bikeuc.dao.IBikeRackDAO;
import edu.uc.bikeuc.dto.BikeRack;

public class BikeRackService implements IBikeRackService {
	//declare a data access object 
	private IBikeRackDAO rackDAO;	

	public BikeRackService(Context ctx) {
		//instantiate the data access object
		rackDAO = new BikeRackDAO(ctx);
	}

	@Override
	public ArrayList<BikeRack> fetchAllRacks() throws Exception {
		//call the method on the data access object
		ArrayList<BikeRack> racks = new ArrayList<BikeRack>();
		racks = rackDAO.fetchAllRacks();
		//return the value
		return racks;
	}

	@Override
	public BikeRack fetchRackById(Integer id) throws Exception {
		//call the method on the data access object
		BikeRack rack = rackDAO.fetchRackById(id);
		//return the value
		return rack;
	}

	@Override
	public BikeRack fetchNearestRack(double lat, double lon) throws Exception {
		//call the method on the data access object
		BikeRack rack = rackDAO.fetchNearestRack(lat, lon);
		//return the value
		return rack;
	}

	@Override
	public void save(BikeRack rack) throws Exception {
		//call the method on the data access object
		rackDAO.save(rack);
		//no return
	}

}
