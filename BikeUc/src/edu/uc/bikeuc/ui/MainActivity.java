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
	private Button buttonObjStub;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//call the super class constructor
		super.onCreate(savedInstanceState);
		//grab the resource xml
		setContentView(R.layout.activity_main);
		
		//instantiate the buttons
		buttonObjAbout = (Button) findViewById(R.id.btnAbout);
		buttonObjBikeRacks = (Button) findViewById(R.id.btnBikeRacks);
		buttonObjBikeRoutes = (Button) findViewById(R.id.btnBikeRoutes);
		buttonObjCamera = (Button) findViewById(R.id.btnCamera);
		buttonObjStub = (Button) findViewById(R.id.btnStub);
		
		//attach onClick listeners to the button objects
		buttonObjStub.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View currentView) {
				//declare the intent
				Intent myIntent = new Intent(currentView.getContext(), StubActivity.class);
				//act on the intent
				startActivityForResult(myIntent,0);
				} //end onClick
			} // end setOnClickListener 
		); //end new View.OnClickListener()
		
	} // end onCreate
}
