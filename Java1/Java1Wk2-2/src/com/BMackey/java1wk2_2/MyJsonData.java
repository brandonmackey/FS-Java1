package com.BMackey.java1wk2_2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

public class MyJsonData {
	static String TAG = "NETWORK DATA - MYJSONDATA";

	static String responseStr;
	static String _MainUrl;

	public static String readJSON(String selected) throws JSONException {

		Log.i("Intructor Test", selected);
		String result, city, state, temp, feelsLike;
		String forecastDay, hiTemp, loTemp, weatherInfo;
		StringBuffer myForecastBuff;
		_MainUrl = selected; 
		String jsonText = "";

		try {
			getData myData = new getData();
			jsonText = myData.execute(_MainUrl).get();
			Log.i("my test",jsonText);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject object = new JSONObject(jsonText);

		try {
			weatherInfo = "";
			myForecastBuff = new StringBuffer();
			 
				city = object.getJSONObject("current_observation").getJSONObject("display_location").getString("city");
				
				state = object.getJSONObject("current_observation").getJSONObject("display_location").getString("state");
				
				temp = object.getJSONObject("current_observation").getString("temp_f");
				
				feelsLike = object.getJSONObject("current_observation").getString("feelslike_f");

				result = "City:  " + city + "\r\n" + "State:  " + state
						+ "\r\n" + "Current Temp: /" + temp + " Feels Like: "
						+ feelsLike + "\r\n";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
			Log.e(TAG, "Error", e);
		}
		return result;
	}

	// Checks Network Status //
	public static Boolean connectionStatus(Context context) {
		Boolean connect = false;
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		String connectionType = "You are not connect to the internet";
		if (ni != null) {
			if (ni.isConnected()) {
				Log.i(TAG, "connection type " + ni.getTypeName());
				connect = true;
				connectionType = ni.getTypeName();
			}
		}
		Log.i(TAG, connectionType);
		return connect;

	}

	public static String getResponse(URL url) {
		
		String response = "";
		
		try {
			URLConnection conn = url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(
					conn.getInputStream());
			byte[] contextByte = new byte[1024];
			int byteRead = 0;
			StringBuffer responseBuffer = new StringBuffer();
			while ((byteRead = bis.read(contextByte)) != -1)
				
			{
				response = new String(contextByte, 0, byteRead);
				responseBuffer.append(response);
			}
			response = responseBuffer.toString();
			Log.i(TAG, response);
		} catch (IOException e) {
			response = "Something happened and we didn't get the info";
			Log.e(TAG, "Something went wrong", e);
		}
		return response;

	}

	static class getData extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			String responseStr = "";
			try {
				URL url = new URL(_MainUrl);
				responseStr = getResponse(url);
			} catch (MalformedURLException e) {
				responseStr = "Something went wrong with getting data!";
				Log.e(TAG, "Error ", e);
			}

			return responseStr;
		}

		@Override
		protected void onPostExecute(String result) {
			// jsonView.setText(result);
			super.onPostExecute(result);
		}

	}

}
