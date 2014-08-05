package edu.uc.bikeuc.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import edu.uc.bikeuc.R;
//import edu.uc.bikeuc.service.BikeRouteServiceStub;
import edu.uc.bikeuc.service.IBikeRouteService;

public class BikeRoutesMapActivity extends Activity {

	private static final int GPS_ERRORDIALOG_REQUEST = 1000;

	private Button buttonHome;

	GoogleMap googleMap;
	MapView mapView;
	Marker marker;
	IBikeRouteService bikeRouteService;
	//BikeRouteServiceStub bikeRouteServiceStub;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (googleServices())
		{
			Toast.makeText(this, "Now Displaying Bike Routes", Toast.LENGTH_LONG).show();
			setContentView(R.layout.activity_bike_routes_map);

			// Find view to display map
			mapView = (MapView) findViewById(R.id.mapRoutes);

			// Create the map that will be displayed
			mapView.onCreate(savedInstanceState);

			// Set the map object
			googleMap = mapView.getMap();

			// Enable GPS services
			googleMap.setMyLocationEnabled(true);

			// Enable compass
			googleMap.getUiSettings().setCompassEnabled(true);

			//fetch a PolylineOptions object to be used for the route
//			PolylineOptions pop = BikeRouteServiceStub.fetchRoute(routeId);
			//initialize the declared service
//			bikeRouteService = new BikeRouteService(this);
//			bikeRouteServiceStub = new BikeRouteServiceStub(this);
			//call a fetch method to force the db to be created
//			bikeRouteService.fetchRouteById(1);
			//fetch a polyline object
			//PolylineOptions pop = bikeRouteService.fetchPop(0);
//			PolylineOptions pop = bikeRouteServiceStub.fetchPop();

			//add the polyline to the map
//			this.googleMap.addPolyline(pop);
				
		}
		else
		{
			setContentView(R.layout.activity_main);
		}		

		buttonHome = (Button) findViewById(R.id.btnRoutesHome);

		buttonHome.setOnClickListener(new View.OnClickListener() 
		{

			@Override
			public void onClick(View currentView) {
				// TODO Auto-generated method stub

				Intent Intent = new Intent();
				setResult(RESULT_OK, Intent);
				finish();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mapView.onResume();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		mapView.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mapView.onPause();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mapView.onDestroy();
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		mapView.onLowMemory();
	}

	/**
	 * Check to make sure ADK is installed on mobile device.
	 * @return
	 */
	public boolean googleServices()
	{	
		int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

		if (isAvailable == ConnectionResult.SUCCESS)
		{
			return true;
		}
		else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable))
		{
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, GPS_ERRORDIALOG_REQUEST);
			dialog.show();
		}
		else
		{
			Toast.makeText(this, "Cannot connect to Google Play Services!", Toast.LENGTH_LONG).show();
		}
		return false;
	}

	public boolean initGoogleMap()
	{
		if( googleMap == null)
		{
			MapView mapView = (MapView) findViewById(R.id.mapRoutes);
			googleMap = mapView.getMap();
		}
		return (googleMap != null);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub

		switch (item.getItemId()) {
		case R.id.mapTypeNormal:
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			break;

		case R.id.mapTypeSatellite:
			googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			break;

		case R.id.mapTypeHybrid:
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			break;

		case R.id.mapTypeTerrain:
			googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}

