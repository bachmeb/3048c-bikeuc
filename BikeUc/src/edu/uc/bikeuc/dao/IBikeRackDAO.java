package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.uc.bikeuc.dto.BikeRack;

public interface IBikeRackDAO {
	
	public abstract void onCreate(SQLiteDatabase db);

	public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
	
	public abstract void onUpdate(SQLiteDatabase db);

	public abstract void save(BikeRack rack) throws Exception;
	
	public abstract ArrayList<BikeRack> fetchAllRacks() throws Exception;
	
	public abstract BikeRack populateRackFromCursor(Cursor c);
	
	public abstract BikeRack fetchRackById(Integer id) throws Exception;

	public abstract BikeRack fetchNearestRack(double lat, double lon)throws Exception;

	
	
}