package edu.uc.bikeuc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import edu.uc.bikeuc.dto.BikeRack;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BikeRackDAO extends SQLiteOpenHelper implements IBikeRackDAO {
	
	private static final String RACK_TABLE = "racks";
	private static final String RACK_ID = "rackId";
	private static final String RACK_NAME = "name";
	private static final String RACK_LAT = "lat";
	private static final String RACK_LNG = "lng";
	

//	public BikeRackDAO(Context context, String name, CursorFactory factory,
//			int version) {
//		super(context, name, factory, version);
//		// TODO Auto-generated constructor stub
//	}

	public BikeRackDAO(Context context) {		
		super(context, "bikeuc", null, 1);
	}

	public void onUpdate(SQLiteDatabase db) {
		//Run a DROP IF EXISTS statement to drop the USERS table.
		//Invoke onCreate.

		db.execSQL("DROP TABLE IF EXISTS '" + RACK_TABLE + "'");

	}

	@Override
	public void save(BikeRack rack) throws Exception {

		// create an insert statement to insert into the database
		// content values is like a hashamp.
		ContentValues cv = new ContentValues(3);
		cv.put(RACK_NAME, rack.getRackName());
		cv.put(RACK_LAT, rack.getLatitude());
		cv.put(RACK_LNG, rack.getLongitude());

		// put into the database.
		getWritableDatabase().insert(RACK_TABLE, RACK_ID, cv);

	}

	@Override
	public ArrayList<BikeRack> fetchAllRacks() throws Exception {
		// Declare the variable that will hold our results.
		ArrayList<BikeRack> racks = new ArrayList<BikeRack>();
		
 		// our flexible query.
		String fetchQuery  = "select * from " + RACK_TABLE ;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);
		
		// move the cursor to the first result.
		cursor.moveToFirst();
		
		// iterate over the cursor until it reaches the last row.
		// notice the ! which negates true to false.
		while(!cursor.isAfterLast()) {
			// populate plant from cursor.
			BikeRack rack = populateRackFromCursor(cursor);

			// add to our collection.
			racks.add(rack);
			
			// move to the next result.
			cursor.moveToNext();
		}
		return racks;
	}

	@Override
	public BikeRack populateRackFromCursor(Cursor c) {
		// create a new object to hold our data.
		BikeRack rack = new BikeRack();

		// populate local variables from our database data.
		String rname = c.getString(c.getColumnIndex(RACK_NAME));
		double rlat = c.getDouble(c.getColumnIndex(RACK_LAT));
		double rlng = c.getDouble(c.getColumnIndex(RACK_LNG));

		// populate the object
		rack.setRackName(rname);
		rack.setLatitude(rlat);
		rack.setLongitude(rlng);
		
		//return the object
		return rack;
	}

	@Override
	public BikeRack fetchRackById(Integer id) throws Exception {

 		// our flexible query.
		String fetchQuery  = "select * from " + RACK_TABLE + " where "+ RACK_ID +" = '" + id +"' ";

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);

		//check the cursor count
		if (cursor.getCount() == 1) {
			// find out who our user is.

			// move our cursor to the first position.
			cursor.moveToFirst();

			BikeRack rack = populateRackFromCursor(cursor);

			// return the populated user.
			return rack;
		} else if (cursor.getCount() > 1){
			throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
		} else {
			// if we got here, we have 0 results.  Return null.
			return null;
		}
	}

	@Override
	public BikeRack fetchNearestRack(double lat, double lon) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreate(SQLiteDatabase db) {

		//drop the USERS table if it exists
		this.onUpdate(db);
		
		// define the schema.
		String dbSchema = "CREATE TABLE "
				+ RACK_TABLE
				+ " ("
				+ RACK_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ RACK_NAME
				+ " TEXT, "
				+ RACK_LAT
				+ " REAL, "
				+ RACK_LNG
				+ " REAL );";

		// create our table.
		db.execSQL(dbSchema);

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// nothing to do here

	}

	@Override
	public String fetchPrime() throws Exception {

 		// our flexible query.
		String fetchQuery  = "select * from " + RACK_TABLE;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);

		//check the cursor count
		if (cursor.getCount() == 1) {
			// find out who our user is.

			// move our cursor to the first position.
			cursor.moveToFirst();

			BikeRack rack = populateRackFromCursor(cursor);
			
			String status = rack.getRackName();

			// return the populated user.
			return status;
		} else if (cursor.getCount() > 1){
			throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
		} else {
			// if we got here, we have 0 results.  Return null.
			return null;
		}
	}

	@Override
	public BikeRack fetchFirstRack() throws Exception {

		// Declare the variable that will hold our results.
		BikeRack firstRack = new BikeRack();
		
 		// our flexible query.
		String fetchQuery  = "select * from " + RACK_TABLE ;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);
		
		// move the cursor to the first result.
		//cursor.moveToFirst();
		
		if (!(cursor.moveToFirst()) || cursor.getCount() ==0){
		     //cursor is empty
		}
		else{
			firstRack = populateRackFromCursor(cursor);
		}
		
		return firstRack;
	}

}
