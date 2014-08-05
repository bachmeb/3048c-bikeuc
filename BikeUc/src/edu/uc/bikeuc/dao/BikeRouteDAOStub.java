package edu.uc.bikeuc.dao;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import edu.uc.bikeuc.dto.BikeRoute;


public class BikeRouteDAOStub extends SQLiteOpenHelper implements IBikeRouteDAO  {

	// Constructor       
	public BikeRouteDAOStub(Context context) {
		//call SQLiteOpenHelper constructor
		super(context, null, null, 0);
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
	 * @see edu.uc.bikeucDAO.IBikeRouteDAO#fetchNearestRoute(double, double)
	 */
	@Override
	public BikeRoute fetchNearestRoute(double lat, double lon){
		BikeRoute route = new BikeRoute();

		return route;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRouteDAO#fetchAllRoutes()
	 */
	@Override
	public ArrayList<BikeRoute> fetchAllRoutes() throws Exception {
		// make a stub list of bike routes 
		ArrayList<BikeRoute> routes = new ArrayList<BikeRoute>();

		ArrayList<LatLng> lls = new ArrayList<LatLng>();
		
		// fill the list
		LatLng ll = new LatLng(3.3,4.4);
		lls.add(ll);
		ll = new LatLng(38.59,33.54);
		lls.add(ll);
		routes.add(new BikeRoute(lls));

		//return the List
		return routes;
	}

	/* (non-Javadoc)
	 * @see edu.uc.bikeucDAO.IBikeRouteDAO#fetchRouteById(java.lang.Integer)
	 */
	@Override
	public BikeRoute fetchRouteById(Integer id) throws Exception {
		// make a route
		BikeRoute route = new BikeRoute();
		//make a latlng
		LatLng ll = new LatLng(34.32,48.45);
		//make an array list
		ArrayList<LatLng> lls = new ArrayList<LatLng>();
		//add the latlng to the arraylist
		lls.add(ll);
		//reset the latlng
		ll = new LatLng(38.59,33.54);
		//add the latlng to the arraylist
		lls.add(ll);
		//add the ArrayList to the route
		route.setLatlngs(lls);
		//return the route
		return route;
	}

	@Override
	public void save(BikeRoute route) throws Exception {
		//saved
		
	}

}
