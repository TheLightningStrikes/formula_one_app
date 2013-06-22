package com.warriorpoint.androidxmlsimple;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RacesList extends ListActivity {
	
	private static int amountOfRaces = 3;
	private static List<String> raceTitles = new ArrayList<String>(amountOfRaces);
	private static List<String> raceDescriptions = new ArrayList<String>(amountOfRaces);
	private static List<String> raceDates = new ArrayList<String>(amountOfRaces);
	private static List<String> raceGeoCodes = new ArrayList<String>(amountOfRaces);
	
	// Alle races
	private static String raceTitle1 = "GP Australië";
	private static String raceTitle2 = "GP Maleisië";
	private static String raceTitle3 = "GP China";
	
	// Alle beschrijvingen
	private static String raceDesc1 = "Albert Park";
	private static String raceDesc2 = "Sepang International Circuit";
	private static String raceDesc3 = "Shanghai International Circuit";
	
	// Alle data
	private static String raceDate1 = "17-03-2013";
	private static String raceDate2 = "24-03-2013";
	private static String raceDate3 = "14-04-2013";	
	
	// Alle geocodes
	private static String raceGeo1 = "geo:0,0?q=" + ("-37.846539, 144.966181");
	private static String raceGeo2 = "geo:0,0?q=" + ("2.761305, 101.731167");
	private static String raceGeo3 = "geo:0,0?q=" + ("31.336909, 121.225253");
	
	static String raceTitle;
	static String raceDescription;
	static String raceDate;
	static String raceGeoCode;
	
	private ListView list;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.rssfeed);
        loadFeed();
        
        
        list = getListView();
    	list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    		  @Override
    		  public void onItemClick(AdapterView<?> parent, View view,
    		    int position, long id) {
    			  raceTitle = raceTitles.get(position);
    			  raceDescription = raceDescriptions.get(position);
    			  raceDate = raceDates.get(position);
    			  raceGeoCode = raceGeoCodes.get(position);
    			  Intent intent = new Intent(RacesList.this, RaceDescription.class);
    			    startActivity(intent);
    		  }
    	}); 
    }

	private void loadFeed(){
    	try{
    		
	    		// Titles
	    		raceTitles.add(raceTitle1);
	    		raceTitles.add(raceTitle2);
	    		raceTitles.add(raceTitle3);
	    		
	    		// Desc
	    		raceDescriptions.add(raceDesc1);
	    		raceDescriptions.add(raceDesc2);
	    		raceDescriptions.add(raceDesc3);
	    		
	    		// Data
	    		raceDates.add(raceDate1);
	    		raceDates.add(raceDate2);
	    		raceDates.add(raceDate3);
	    		
	    		// Geocode
	    		raceGeoCodes.add(raceGeo1);
	    		raceGeoCodes.add(raceGeo2);
	    		raceGeoCodes.add(raceGeo3);

	    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,raceTitles);
	    	this.setListAdapter(adapter);
    	} catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}
	}
}
