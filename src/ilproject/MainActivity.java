package ilproject;

import la.droid.qr.services.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity {

	//Actions
	public static final String SCAN = "la.droid.qr.scan";
	public static final String ENCODE = "la.droid.qr.encode";
	public static final String DECODE = "la.droid.qr.decode";

	//Result
	public static final String RESULT = "la.droid.qr.result";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);
        
        //Recycled objects
	    Resources res = getResources();
	    TabHost tabHost = getTabHost();
	    TabHost.TabSpec spec;
	    Intent intent;
 
	    //Scan Activity
	    
	    intent = new Intent().setClass(this, Client.class);
	    spec = tabHost.newTabSpec("Client").setIndicator("", res.getDrawable(R.drawable.client)).setContent(intent);
	    tabHost.addTab(spec);
	    
	    intent = new Intent().setClass(this, Waiter.class);
	    spec = tabHost.newTabSpec("Waiter").setIndicator("", res.getDrawable(R.drawable.waiter)).setContent(intent);
	    tabHost.addTab(spec);
	    
    }

    

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	//Nothing
    }
}