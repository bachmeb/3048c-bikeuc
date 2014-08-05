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

	private Button buttonObjStub;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		buttonObjStub = (Button) findViewById(R.id.btnStub);
		
		//attach an onclick listener to the button object
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
