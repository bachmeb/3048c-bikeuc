package edu.uc.bikeuc.ui;

import edu.uc.bikeuc.R;
import edu.uc.bikeuc.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	//declare the buttons
	private Button buttonObjAbout;
	private Button buttonObjBikeRacks;
	private Button buttonObjBikeRoutes;
	private Button buttonObjCamera;
	private Button buttonObjStubRacks;
	private Button buttonObjStubRoutes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//call the super class constructor
		super.onCreate(savedInstanceState);
		//grab the resource xml
		setContentView(R.layout.activity_main);
		
		//instantiate the buttons in the onCreate method
		buttonObjAbout = (Button) findViewById(R.id.btnAbout);
		buttonObjBikeRacks = (Button) findViewById(R.id.btnBikeRacks);
		buttonObjBikeRoutes = (Button) findViewById(R.id.btnBikeRoutes);
		buttonObjCamera = (Button) findViewById(R.id.btnCamera);
		buttonObjStubRacks = (Button) findViewById(R.id.btnStubRacks);
		buttonObjStubRoutes = (Button) findViewById(R.id.btnStubRoutes);
		
		//attach onClick listeners to the button objects
		buttonObjStubRacks.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), StubRackActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()
		
		//attach onClick listeners to the button objects
		buttonObjStubRoutes.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), StubRouteActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		
		//attach onClick listeners to the button objects
		buttonObjAbout.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), AboutActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		
		//attach onClick listeners to the button objects
		buttonObjBikeRoutes.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), BikeRoutesMapActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		
		//attach onClick listeners to the button objects
		buttonObjBikeRacks.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), BikeRacksMapActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()

		
		//attach onClick listeners to the button objects
		buttonObjCamera.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), TakePictureActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()
		
	} // end onCreate
}
