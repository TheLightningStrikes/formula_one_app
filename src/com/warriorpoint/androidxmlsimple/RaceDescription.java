package com.warriorpoint.androidxmlsimple;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RaceDescription extends Activity {
	
	private String geoCodeUrl = RacesList.raceGeoCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_race_description);
		loadDescription();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.race_description, menu);
		return true;
	}
	
	private void loadDescription() {
	    // Create the text view for the title of the message
	    TextView textView = (TextView) findViewById(R.id.textView1);
	    textView.setTextSize(24);
	    textView.setText(RacesList.raceTitle);
	    
	    // Create the text view for the publishing date of the message
	    TextView textView2 = (TextView) findViewById(R.id.textView2);
	    textView2.setTextSize(12);
	    textView2.setText(RacesList.raceDate);
	
	    // Create the text view for the description of the message
	    TextView textView3 = (TextView) findViewById(R.id.textView3);
	    textView3.setTextSize(16);
	    textView3.setText(RacesList.raceDescription);
	    
	    // Create a button with the geocode to the circuit
	    Button mapsButton = (Button) findViewById(R.id.button1);
		mapsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			    String uri = geoCodeUrl;        
			    Intent goToMaps = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
			    startActivity(goToMaps); 
			}
		});
		
	}	
}
