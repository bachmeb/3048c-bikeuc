package edu.uc.bikeuc.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.android.gms.maps.model.LatLng;

import edu.uc.bikeuc.dto.BikeRoute;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BikeRouteDAO extends SQLiteOpenHelper implements IBikeRouteDAO {
	
	private static final String ROUTE_TABLE = "routes";
	private static final String ROUTE_ID = "routeId";
	private static final String ROUTE_NAME = "name";
	private static final String ROUTE_LAT = "lat";
	private static final String ROUTE_LNG = "lng";
	

//	public BikeRouteDAO(Context context, String name, CursorFactory factory,
//			int version) {
//		super(context, name, factory, version);
//		// TODO Auto-generated constructor stub
//	}

	public BikeRouteDAO(Context context) {		
		super(context, "bikeuc", null, 1);
	}

	public void onUpdate(SQLiteDatabase db) {
		//Run a DROP IF EXISTS statement to drop the USERS table.
		//Invoke onCreate.

		db.execSQL("DROP TABLE IF EXISTS '" + ROUTE_TABLE + "'");

	}

	@Override
	public void save(BikeRoute route) throws Exception {

		
		ArrayList<LatLng> lls = route.getLatlngs();
		for (LatLng ll : lls){

			// create an insert statement to insert into the database
			// content values is like a hashamp.
			ContentValues cv = new ContentValues(3);
			cv.put(ROUTE_NAME, route.getRouteName());
			cv.put(ROUTE_LAT, ll.latitude);
			cv.put(ROUTE_LNG, ll.longitude);
			// put into the database.
			getWritableDatabase().insert(ROUTE_TABLE, ROUTE_ID, cv);

		}
		

	}

	@Override
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception {
		// Declare the variable that will hold our results.
		ArrayList<BikeRoute> routes = new ArrayList<BikeRoute>();
		
 		// our flexible query.
		String fetchQuery  = "select * from " + ROUTE_TABLE ;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);
		
		// move the cursor to the first result.
		cursor.moveToFirst();
		
		// iterate over the cursor until it reaches the last row.
		// notice the ! which negates true to false.
		while(!cursor.isAfterLast()) {
			// populate plant from cursor.
			BikeRoute route = populateRouteFromCursor(cursor);

			// add to our collection.
			routes.add(route);
			
			// move to the next result.
			cursor.moveToNext();
		}
		return routes;
	}

	@Override
	public BikeRoute populateRouteFromCursor(Cursor c) {
		// create a new object to hold our data.
		BikeRoute route = new BikeRoute();

		// populate local variables from our database data.
		String rname = c.getString(c.getColumnIndex(ROUTE_NAME));
		double rlat = c.getDouble(c.getColumnIndex(ROUTE_LAT));
		double rlng = c.getDouble(c.getColumnIndex(ROUTE_LNG));

		// populate the object
		route.setRouteName(rname);
		LatLng ll = new LatLng(rlat,rlng);
		ArrayList<LatLng> lls = new ArrayList<LatLng>();
		lls.add(ll);
		route.setLatlngs(lls);
		
		//return the object
		return route;
	}

	@Override
	public BikeRoute fetchRouteById(Integer id) throws Exception {

 		// our flexible query.
		String fetchQuery  = "select * from " + ROUTE_TABLE + " where "+ ROUTE_ID +" = '" + id +"' ";

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);

		//check the cursor count
		if (cursor.getCount() == 1) {

			// move our cursor to the first position.
			cursor.moveToFirst();

			//get the first result
			BikeRoute route = populateRouteFromCursor(cursor);

			// return the populated object
			return route;
		} else if (cursor.getCount() > 1){
			throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
		} else {
			// if we got here, we have 0 results.  Return null.
			return null;
		}
	}

	@Override
	public BikeRoute fetchNearestRoute(double lat, double lon) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void onCreate(SQLiteDatabase db) {

		//drop the table if it exists
		this.onUpdate(db);
		
		// define the schema.
		String dbSchema = "CREATE TABLE "
				+ ROUTE_TABLE
				+ " ("
				+ ROUTE_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ ROUTE_NAME
				+ " TEXT, "
				+ ROUTE_LAT
				+ " REAL, "
				+ ROUTE_LNG
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
		String fetchQuery  = "select * from " + ROUTE_TABLE;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);

		//check the cursor count
		if (cursor.getCount() == 1) {
			// move our cursor to the first position.
			cursor.moveToFirst();

			//get the first result
			BikeRoute route = populateRouteFromCursor(cursor);
			
			String status = route.getRouteName();

			// return a status message
			return status;
		} else if (cursor.getCount() > 1){
			throw new Exception("Too many results returned.  Expected 1, got " + cursor.getCount());
		} else {
			// if we got here, we have 0 results.  Return null.
			return null;
		}
	}

	@Override
	public BikeRoute fetchFirstRoute() throws Exception {

		// Declare the variable that will hold our results.
		BikeRoute firstRoute = new BikeRoute();
		
 		// our flexible query.
		String fetchQuery  = "select * from " + ROUTE_TABLE ;

		// run the query.
		Cursor cursor = getReadableDatabase().rawQuery(fetchQuery, null);
		
		// move the cursor to the first result.
		//cursor.moveToFirst();
		
		if (!(cursor.moveToFirst()) || cursor.getCount() ==0){
		     //cursor is empty
		}
		else{
			firstRoute = populateRouteFromCursor(cursor);
		}
		
		return firstRoute;
	}

}
