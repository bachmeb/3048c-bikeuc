package edu.uc.bikeuc.ui;

import java.util.ArrayList;

import com.google.android.gms.maps.model.LatLng;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import edu.uc.bikeuc.R;
import edu.uc.bikeuc.dto.BikeRoute;
import edu.uc.bikeuc.service.BikeRouteService;
import edu.uc.bikeuc.service.IBikeRouteService;

public class StubRouteActivity extends Activity {
	
	//declare a service object
	private IBikeRouteService routeService;
	
	//declare stub values
	private BikeRoute stubRoute;
	private String stubRouteName;
	private double stubRouteLat;
	private double stubRouteLng;
	private ArrayList<LatLng> stubLatLngs;
	
	//declare the buttons as class variables
	private Button buttonObjFetchAllRoutes;
	private Button buttonObjFetchFirstRoute;
	private Button buttonObjFetchNearestRoute;
	private Button buttonObjFetchRoutesById;
	private Button buttonObjSaveRoute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//call the super class
		super.onCreate(savedInstanceState);
		//set the view to resource xml
		setContentView(R.layout.activity_stub_route);

		//instantiate stub values

		stubRouteName = "the stub route";
		stubRouteLat = 67.54;
		stubRouteLng = 45.65;
		stubLatLngs = new ArrayList<LatLng>();
		stubLatLngs.add(new LatLng(stubRouteLat, stubRouteLng));
		stubRoute = new BikeRoute(stubRouteName, stubLatLngs);

        // instantiate and initialize the service objects
        routeService = new BikeRouteService(this);

        // call a service method, 
        // which will call a data access object method
        // which will call a getReadableDatabase method
        // which will cause the db to be created, 
        // if it hasn't already been created
        try {
			String test = routeService.fetchPrime();
		} catch (Exception e) {
			// exception
			e.printStackTrace();
			//make some toast
			Toast.makeText(
					getApplicationContext(), 
					"EXCEPTION FOR FETCH PRIME",
					Toast.LENGTH_LONG)
				.show();
		}
		
		//instantiate the buttons in the onCreate method
        buttonObjFetchAllRoutes = (Button) findViewById(R.id.btnFetchAllRoutes);
        buttonObjFetchFirstRoute = (Button) findViewById(R.id.btnFetchFirstRoute);
        buttonObjFetchNearestRoute = (Button) findViewById(R.id.btnFetchNearestRoute);
		buttonObjFetchRoutesById = (Button) findViewById(R.id.btnFetchRouteById);
		buttonObjSaveRoute = (Button) findViewById(R.id.btnSaveRoute);

		//attach onClick listeners to the button objects
		buttonObjFetchRoutesById.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {

				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch route by id",
						Toast.LENGTH_LONG)
					.show();

				// call a method on the service object
				try {
					stubRoute = routeService.fetchRouteById(1);
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"got " + stubRoute.getRouteName(),
							Toast.LENGTH_LONG)
						.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"EXCEPTION: DIDNT GET A RACK",
							Toast.LENGTH_LONG)
						.show();
				}

				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjFetchAllRoutes.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch all routes",
						Toast.LENGTH_LONG)
					.show();


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjFetchFirstRoute.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch first route",
						Toast.LENGTH_LONG)
					.show();

				// call a method on the service object
				try {
					BikeRoute route = routeService.fetchFirstRoute();
					String result = route.getRouteName();
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"Got " + result,
							Toast.LENGTH_LONG)
						.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"EXCEPTION",
							Toast.LENGTH_LONG)
						.show();
				}


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjFetchNearestRoute.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch nearest route",
						Toast.LENGTH_LONG)
					.show();


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjSaveRoute.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to save",
						Toast.LENGTH_LONG)
					.show();
				// call a method on the service object
				try {
					routeService.save(stubRoute);
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"UI THINKS RACK WAS SAVED",
							Toast.LENGTH_LONG)
						.show();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"EXCEPTION",
							Toast.LENGTH_LONG)
						.show();
				}


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()
		
	} //end onCreate
}
