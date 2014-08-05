package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.uc.bikeuc.dto.BikeRack;
import edu.uc.bikeuc.dto.BikeRoute;

public interface IBikeRouteDAO {
	
	public abstract void onCreate(SQLiteDatabase db);

	public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
	
	public abstract void onUpdate(SQLiteDatabase db);

	public abstract BikeRack populateRackFromCursor(Cursor c);

	public abstract ArrayList<BikeRoute> fetchAllRoutes() throws Exception;

	public abstract BikeRoute fetchRouteById(Integer id) throws Exception;

	public abstract BikeRoute fetchNearestRoute(double lat, double lon) throws Exception;

	public abstract void save(BikeRoute route) throws Exception;

}
