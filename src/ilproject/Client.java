package ilproject;

import la.droid.qr.services.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Client extends Activity {

	private static final int ACTIVITY_RESULT_QR_DRDROID = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.scan);
		
		
		//"Scan" button
		final Button button = (Button) findViewById(R.id.button_scan);
		//Set action to button
		button.setOnClickListener( new OnClickListener() {
			@Override
			public void onClick(View v) {
				//Create a new Intent to send to QR Droid
				Intent qrDroid = new Intent(MainActivity.SCAN ); //Set action "la.droid.qr.scan"
				
				//Send intent and wait result
				try {
					startActivityForResult(qrDroid, ACTIVITY_RESULT_QR_DRDROID);
				} catch (ActivityNotFoundException activity) {
				}
			}
		});
	}

	@Override
	/**
	 * Reads data scanned by user and returned by QR Droid
	 */
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if( ACTIVITY_RESULT_QR_DRDROID==requestCode && null!=data && data.getExtras()!=null ) {
			//Read result from QR Droid (it's stored in la.droid.qr.result)
			String result = data.getExtras().getString(MainActivity.RESULT);
			//Just set result to EditText to be able to view it
			EditText resultTxt = ( EditText ) findViewById(R.id.result);
			resultTxt.setText( result );
			resultTxt.setVisibility(View.VISIBLE);
		}
	}
	
	@Override
    public void onConfigurationChanged(Configuration newConfig) {
    	super.onConfigurationChanged(newConfig);
    	//Nothing
    }
}
