package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.uc.bikeuc.dto.BikeRack;


public class BikeRackDAOStub extends SQLiteOpenHelper implements IBikeRackDAO  {

	// Constructor       
	public BikeRackDAOStub(Context context) {
		//call SQLiteOpenHelper constructor
		super(context, null, null, 0);
	}	

	// Inserts a new location to the table locations
	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#insert(android.content.ContentValues)
	 */
	@Override
	public long insert(ContentValues contentValues){
		long rowID = 123;
		return rowID;
	}

	// Deletes all Bike rack locations from the table 
	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#del()
	 */
	@Override
	public int del(){
		int cnt = 99;
		return cnt;
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRackDAO#fetchNearestRack(double, double)
	 */
	@Override
	public BikeRack fetchNearestRack(double lat, double lon){
		BikeRack rack = new BikeRack(123.123,456.456);
		
		return rack;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRackDAO#fetchAllRacks()
	 */
	@Override
	public ArrayList<BikeRack> fetchAllRacks() throws Exception {
		// make a stub list of bike racks 
		ArrayList<BikeRack> racks = new ArrayList<BikeRack>();

		// fill the list
		racks.add(new BikeRack(1.1,3.3));
		racks.add(new BikeRack(1.1,3.3,"rack two dao"));

		//return the List
		return racks;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRackDAO#fetchRackById(java.lang.Integer)
	 */
	@Override
	public BikeRack fetchRackById(Integer id) {
		// make a rack
		BikeRack rack = new BikeRack(77.77,88.88,"fetchedById from DAO");
		//return the rack
		return rack;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRackDAO#save(edu.uc.bikeucDTO.BikeRack)
	 */
	@Override
	public void save(BikeRack rack) throws Exception {
		//void
		
	}

}
