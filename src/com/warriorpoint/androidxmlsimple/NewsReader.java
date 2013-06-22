package com.warriorpoint.androidxmlsimple;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class NewsReader extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news_reader);
		loadDescription();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.news_reader, menu);
		return true;
	}

	private void loadDescription() {
	    // Create the text view for the title of the message
	    TextView textView = (TextView) findViewById(R.id.textView1);
	    textView.setTextSize(24);
	    textView.setText(MessageList.titleString);
	    
	    // Create the text view for the publishing date of the message
	    TextView textView2 = (TextView) findViewById(R.id.textView2);
	    textView2.setTextSize(12);
	    textView2.setText(MessageList.dateString);
	
	    // Create the text view for the description of the message
	    TextView textView3 = (TextView) findViewById(R.id.textView3);
	    textView3.setTextSize(16);
	    textView3.setText(MessageList.descriptionString);
	    
	    // Create the text view with the URL to the full article
	    TextView textView4 = (TextView) findViewById(R.id.textView4);  
	    String linkText = "Voor het volledige artikel, klik <a href=\""+MessageList.linkProtocol+"://"+MessageList.linkHost+MessageList.linkPath+"\">hier</a>";
	    textView4.setMovementMethod(LinkMovementMethod.getInstance());
	    textView4.setText(Html.fromHtml(linkText));
	    
	}
}
