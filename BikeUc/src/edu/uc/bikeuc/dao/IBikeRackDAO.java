package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.uc.bikeuc.dto.BikeRack;

public interface IBikeRackDAO {

	public void save(BikeRack rack) throws Exception;
	
	public ArrayList<BikeRack> fetchAllRacks() throws Exception;
	
	public BikeRack populateRackFromCursor(Cursor c);
	
	public BikeRack fetchRackById(Integer id) throws Exception;

	public BikeRack fetchNearestRack(double lat, double lon)throws Exception;
	
	public String fetchPrime() throws Exception;

	public BikeRack fetchFirstRack() throws Exception;
	
	
}