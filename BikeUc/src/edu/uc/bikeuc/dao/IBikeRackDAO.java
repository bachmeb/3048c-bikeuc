package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import edu.uc.bikeuc.dto.BikeRack;

public interface IBikeRackDAO {

	//Table name with in the database
	public static final String TABLE_NAME = "RKLocations";
	//Columns with in the tables
	public static final String COLUMN_ROWID = "_id";
	public static final String COLUMN_LAT = "lat";
	public static final String COLUMN_LNG = "lng";
	public static final String COLUMN_ZOOM = "zom";

	public abstract void onCreate(SQLiteDatabase db);

	// Inserts a new location to the table locations
	public abstract long insert(ContentValues contentValues);

	// Deletes all Bike rack locations from the table 
	public abstract int del();

	public abstract void onUpgrade(SQLiteDatabase db, int oldVersion,
			int newVersion);
	
	//get an array list of bike racks
	ArrayList<BikeRack> fetchAllRacks() throws Exception;

	//get a single bike rack in return for an integer
	BikeRack fetchRackById(Integer id);

	//get a single bike rack in return for latitude and longitude
	BikeRack fetchNearestRack(double lat, double lon);

	void save(BikeRack rack) throws Exception;
	
}