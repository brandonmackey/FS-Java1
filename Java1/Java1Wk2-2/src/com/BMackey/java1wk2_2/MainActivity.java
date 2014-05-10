// Brandon Mackey
// Java 1 
// Week 3 
// Term: 1404

package com.BMackey.java1wk2_2;

import com.BMackey.java1wk2_2.MyJsonData;
import com.BMackey.java1wk2_2.MyJsonData.getData;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	static String TAG = "NETWORK DATA - MYJSONDATA";
	static Context context;
	public static String _urlString = "http://api.wunderground.com/api/dc727ab887dd3079/conditions/q/";
	static TextView jsonView;
	String currentWeatherSelected;
	String forecastWeatherSelected;

		
	Context mContext;
	String[] cityArray;
	String[] forecastArray;


	
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		

		context = this;
		
		//Initializing Constants
		mContext = this;
		cityArray = getResources().getStringArray(R.array.city_array); 
		forecastArray = getResources().getStringArray(R.array.forecast_array); 

		
/////// NETWORK CONNECTION CHECK //////////////////////////////////////////////////////////////
		if(MyJsonData.connectionStatus(mContext)){
			MyJsonData.getData data = new getData();
			data.execute(_urlString);

		}
		else{
			AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
			alert.setTitle("ERROR!");
			alert.setMessage("No Internet Connection Please Reconnect!");
			alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (DialogInterface.OnClickListener) null);
			alert.show();
		}
		
//////// Creating the Spinner //////////////////////////////////////////////////////////////////

		Spinner currentWeatherSpin = (Spinner) findViewById(R.id.spinner1);
		currentWeatherSpin.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

				if(cityArray[position] == null){
					cityArray[position] = "Indianapolis";
				}else {
				
				currentWeatherSelected = cityArray[position];
				}

				String myStr = null;
				try {

					myStr = MyJsonData.readJSON(createURL(currentWeatherSelected, forecastWeatherSelected));

				} catch (JSONException e) {

					// TODO Auto-generated catch block
					e.printStackTrace();
					Log.e(TAG, "Error", e);
				}

				
				Toast.makeText(mContext, "You have selected " + cityArray[position] + " weather", Toast.LENGTH_LONG).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Second Spinner // 
		// Creating the Spinner //

				final Spinner forecastSpin = (Spinner) findViewById(R.id.spinner2);
				forecastSpin.getSelectedItem();
				forecastSpin.getSelectedItemPosition();
				forecastSpin.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view,
							int position, long id) {

						
						forecastWeatherSelected = forecastArray[position];

						String myStr = null;
						try {

							myStr = MyJsonData.readJSON(createURL(currentWeatherSelected, forecastWeatherSelected));

						} catch (JSONException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();
							Log.e(TAG, "Error", e);
						}
						
			
						
			/////////////// Create TextView for Current Weather ////////////////////////////////////////////////////////
										final TextView textView = (TextView) findViewById(R.id.textView1);
										textView.setTextSize(26);
										textView.getText().toString();
										
						
						
						Toast.makeText(mContext, "You have selected " + forecastArray[position] + " weather", Toast.LENGTH_LONG).show();

					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub

					}
					
				});
			
	

							
							
							// String myStr2 = null;
							// try {
							//
							// myStr2 = MyJsonData.readJSON(forecastWeatherSelected);
							//
							// } catch (JSONException e) {
							//
							// // TODO Auto-generated catch block
							// e.printStackTrace();
							// Log.e("TEXTVIEW", "Load TEXVIEW Error", e);
							// }
							//
							// textView.setText(myStr2);
				
	}

/////// CREATE URL STRING //////////////////////////////////////////////////////////////////////////////// 	
		private String createURL(String cityVal, String forecastVal) {
			String retURL;

			retURL = _urlString + cityVal + forecastVal + ".json";

			return retURL;

		}
	
}
