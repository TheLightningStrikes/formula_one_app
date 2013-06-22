package com.warriorpoint.androidxmlsimple;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button nieuwsButton;
	private Button racesButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nieuwsButton =  (Button) findViewById(R.id.button3);
		racesButton = (Button) findViewById(R.id.button1);
		
		nieuwsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, MessageList.class);
				startActivity(intent);
			}
		});
		
		racesButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {  
			    Intent i = new Intent(MainActivity.this, RacesList.class);
			    startActivity(i); 
			}
		});
		
	}	
}
