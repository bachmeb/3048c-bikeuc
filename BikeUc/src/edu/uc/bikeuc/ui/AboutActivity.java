package edu.uc.bikeuc.ui;

import edu.uc.bikeuc.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends Activity {

	private Button buttonHome;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		buttonHome = (Button) findViewById(R.id.btnMainPage);
		
		buttonHome.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View currentView) {
				// TODO Auto-generated method stub

				Intent Intent = new Intent();
				setResult(RESULT_OK, Intent);
				finish();

			}
		});
		
	}
}
