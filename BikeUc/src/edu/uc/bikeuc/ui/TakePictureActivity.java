package edu.uc.bikeuc.ui;

import edu.uc.bikeuc.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TakePictureActivity extends Activity {
	//final int declared for the camera
	static final int REQUEST_IMAGE_CAPTURE = 1;

	//declare a Button object for the open camera 
	private Button buttonOpenCamera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//
		super.onCreate(savedInstanceState);
		//
		setContentView(R.layout.activity_take_picture);

		//get a handle to the camera button
		buttonOpenCamera = (Button) findViewById(R.id.btnOpenCamera);
		
		//set an onclick listener on the button
		buttonOpenCamera.setOnClickListener(new View.OnClickListener() 
		{
			@Override
			public void onClick(View currentView) {
				// method call to open camera
				dispatchTakePictureIntent();

			}
		});
		
	}


	private void dispatchTakePictureIntent() {
	    //declare intent
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		//use the resolveActivity method to make sure the return value of getPackageManager is not null
	    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	        //act on the intent
	    	startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
	    }
	}
	
}
