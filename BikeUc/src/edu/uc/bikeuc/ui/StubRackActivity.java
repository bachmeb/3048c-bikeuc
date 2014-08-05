package edu.uc.bikeuc.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import edu.uc.bikeuc.R;
import edu.uc.bikeuc.dto.BikeRack;
import edu.uc.bikeuc.service.BikeRackService;
import edu.uc.bikeuc.service.IBikeRackService;

public class StubRackActivity extends Activity {
	
	//declare a service object
	private IBikeRackService rackService;
	
	//declare stub values
	private BikeRack stubRack;
	private String stubRackName;
	private double stubRackLat;
	private double stubRackLng;
	
	//declare the buttons as class variables
	private Button buttonObjFetchAllRacks;
	private Button buttonObjFetchFirstRack;
	private Button buttonObjFetchNearestRack;
	private Button buttonObjFetchRacksById;
	private Button buttonObjSaveRack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//call the super class
		super.onCreate(savedInstanceState);
		//set the view to resource xml
		setContentView(R.layout.activity_stub_rack);

		//instantiate stub values
		stubRackName = "the stub rack";
		stubRackLat = 99.44;
		stubRackLng = 85.55;
		stubRack = new BikeRack(stubRackLat,stubRackLng,stubRackName);

        // instantiate and initialize the service objects
        rackService = new BikeRackService(this);

        // call a service method, 
        // which will call a data access object method
        // which will call a getReadableDatabase method
        // which will cause the db to be created, 
        // if it hasn't already been created
        try {
			String test = rackService.fetchPrime();
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
        buttonObjFetchAllRacks = (Button) findViewById(R.id.btnFetchAllRacks);
        buttonObjFetchFirstRack = (Button) findViewById(R.id.btnFetchFirstRack);
        buttonObjFetchNearestRack = (Button) findViewById(R.id.btnFetchNearestRack);
		buttonObjFetchRacksById = (Button) findViewById(R.id.btnFetchRackById);
		buttonObjSaveRack = (Button) findViewById(R.id.btnSaveRack);

		//attach onClick listeners to the button objects
		buttonObjFetchRacksById.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {

				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch rack by id",
						Toast.LENGTH_LONG)
					.show();

				// call a method on the service object
				try {
					stubRack = rackService.fetchRackById(1);
					//make some toast
					Toast.makeText(
							getApplicationContext(), 
							"got " + stubRack.getRackName(),
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
		buttonObjFetchAllRacks.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch all racks",
						Toast.LENGTH_LONG)
					.show();


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjFetchFirstRack.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch first rack",
						Toast.LENGTH_LONG)
					.show();

				// call a method on the service object
				try {
					BikeRack rack = rackService.fetchFirstRack();
					String result = rack.getRackName();
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
		buttonObjFetchNearestRack.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//make some toast
				Toast.makeText(
						getApplicationContext(), 
						"trying to fetch nearest rack",
						Toast.LENGTH_LONG)
					.show();


				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		//attach onClick listeners to the button objects
		buttonObjSaveRack.setOnClickListener(new View.OnClickListener(){
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
					rackService.save(stubRack);
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
