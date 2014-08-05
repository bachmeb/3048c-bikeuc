package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.android.gms.maps.model.LatLng;

import edu.uc.bikeuc.dto.BikeRoute;


public class BikeRouteDAO extends SQLiteOpenHelper implements IBikeRouteDAO{
	
	public static final String ROUTES_TABLE = "routes"; 
	public static final String ROUTE_ID = "routeId";	   
	public static final String LAT = "lat";
	public static final String LNG = "lng";
	public static final String DATABASE_NAME = "bikeuc.db";
	public static final int DATABASE_VERSION = 1;

	//private SQLiteDatabase db;

	//Accept a Context object. Pass it and the values to the super constructor.
	public BikeRouteDAO(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}


	@Override
	public void save(BikeRoute route) throws Exception {
		
		// create an insert statement to insert this user into the database
		// content values is like a hashamp.
		ContentValues cv = new ContentValues(3);
		//get the routeId
		//int rid = route.getRouteId();
		//get an array list of the lat-longs
		ArrayList<LatLng> lls = new ArrayList<LatLng>();
		//put the lat-longs into a local arraylist
		lls = route.getLatlngs();
		//loop through the arraylist
		for (LatLng ll : lls){
			//cv.put(ROUTE_ID, rid);
			cv.put(LAT, ll.latitude);
			cv.put(LNG, ll.longitude);
			
			// put into the database.
			this.getWritableDatabase().insert(ROUTES_TABLE, ROUTE_ID, cv);
		}

	}
	


	/**
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		//drop the USERS table if it exists
		this.onUpdate(db);
		
		// define the schema.
		String routeSchema = "CREATE TABLE "
				+ ROUTES_TABLE
				+ " ("
				+ ROUTE_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, "								
				+ LAT
				+ " TEXT, "
				+ LNG
				+ " TEXT );";

		// create the table.
		db.execSQL(routeSchema);
	}


	private void onUpdate(SQLiteDatabase db2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BikeRoute fetchRouteById(Integer id) {
 		// our flexible query.
		String fetchQuery  = "select * from " + ROUTES_TABLE + " where "+ ROUTE_ID +" = '" + id +"' ";

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);


		if (cursor.getCount() == 1) {
			// find out who our user is.

			// move our cursor to the first position.
			cursor.moveToFirst();

			BikeRoute route = populateRouteFromCursor(cursor);

			// return the populated user.
			return route;
		} else if (cursor.getCount() > 1){
			try {
				throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// if we got here, we have 0 results.  Return null.
			return null;
		}
		return null;
	}


	@Override
	public BikeRoute fetchNearestRoute(double lat, double lon) {
		// TODO Auto-generated method stub
		return null;
	}

	private BikeRoute populateRouteFromCursor(Cursor cursor) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	

   
}