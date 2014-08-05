package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.uc.bikeuc.dto.BikeRack;


public class BikeRackDAO extends SQLiteOpenHelper implements IBikeRackDAO  {

	//Instance a variable for SQLite database
	private SQLiteDatabase RKDb;
	// Database name found in SQLite database
	private static final String DATABASE_NAME = "BikRaks";
	// Version Number of the "BikRaks" database
	private static final int DATABASE_VERSION = 1;


	//Define the database
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_NAME + "( " + COLUMN_ROWID
			+ " integer primary key autoincrement, " +
			COLUMN_LNG + " double , " +
			COLUMN_LAT + " double , " +
			COLUMN_ZOOM + " text " + " ) ";

	// Constructor       
	public BikeRackDAO(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.RKDb = getWritableDatabase();
	}	


	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		db.execSQL(DATABASE_CREATE);
	}

	// Inserts a new location to the table locations
	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#insert(android.content.ContentValues)
	 */
	@Override
	public long insert(ContentValues contentValues){
		long rowID = RKDb.insert(TABLE_NAME, null, contentValues);
		return rowID;
	}

	// Deletes all Bike rack locations from the table 
	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#del()
	 */
	@Override
	public int del(){
		int cnt = RKDb.delete(TABLE_NAME, null , null);
		return cnt;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}


	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRAckDAO#save(edu.uc.bikeucDTO.BikeDTO)
	 */
	@Override
	public void save(BikeRack rack) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<BikeRack> fetchAllRacks() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BikeRack fetchRackById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BikeRack fetchNearestRack(double lat, double lon) {
		// TODO Auto-generated method stub
		return null;
	}

}
