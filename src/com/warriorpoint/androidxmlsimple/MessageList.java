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
public class MessageList extends ListActivity {
	
	// Set variables
	private static BaseFeedParser parser = new BaseFeedParser() ;
	private static List<Message> messages = parser.parse();
	private ListView list;
	private static List<String> titles = new ArrayList<String>(messages.size());
	private static List<String> descriptions = new ArrayList<String>(messages.size());
	private static List<String> dates = new ArrayList<String>(messages.size());
	private static List<String> paths = new ArrayList<String>(messages.size());
	private static List<String> hosts = new ArrayList<String>(messages.size());
	private static List<String> protocols = new ArrayList<String>(messages.size());
	public static String titleString;
	public static String descriptionString;
	public static String dateString;
	public static String linkPath;
	public static String linkHost;
	public static String linkProtocol;
	
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
    			  titleString = titles.get(position);
    			  descriptionString = descriptions.get(position);
    			  dateString = dates.get(position);
    			  linkHost = hosts.get(position);
    			  linkPath = paths.get(position);
    			  linkProtocol = protocols.get(position);
    			  Intent intent = new Intent(MessageList.this, NewsReader.class);
    			    startActivity(intent);
    		  }
    	}); 
    }

	private void loadFeed(){
    	try{
	    	for (Message msg : messages){
	    		titles.add(msg.getTitle());
	    		descriptions.add(msg.getDescription());
	    		dates.add(msg.getDate());
	    		paths.add(msg.getLink().getPath());
	    		hosts.add(msg.getLink().getHost());
	    		protocols.add(msg.getLink().getProtocol());
	    	}
	    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row,titles);
	    	this.setListAdapter(adapter);
    	} catch (Throwable t){
    		Log.e("AndroidNews",t.getMessage(),t);
    	}
	}
}