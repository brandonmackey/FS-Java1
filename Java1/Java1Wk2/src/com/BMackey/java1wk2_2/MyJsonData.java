package com.BMackey.java1wk2_2;

import org.json.JSONException;
import org.json.JSONObject;

public class MyJsonData {
	
	
	
	public static JSONObject createJson(){
		// create weather JSONobject
		JSONObject weatherObject = new JSONObject();
		
		// create enum JSONobject
		JSONObject queryObject = new JSONObject();
		try {
		// create weather objects in enum
		for(myEnum weather : myEnum.values()){
			
			//create weather object
			JSONObject weatherInfo = new JSONObject();
			
			//add info to object
			weatherInfo.put("hi", weather.setHi());
			
				weatherInfo.put("lo", weather.setLo());
		
			weatherInfo.put("dayType", weather.setDayType());
			
			queryObject.put(weather.name().toString(), weatherInfo);
			

		}
		
		weatherObject.put("query", queryObject);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return weatherObject;
	}
	
	public static String readJSON(String selected){
		
		String result, hi, lo, dayType;
		
		JSONObject object = createJson();
		
		try {
			hi      = object.getJSONObject("query").getJSONObject(selected).getString("hi");
			lo      = object.getJSONObject("query").getJSONObject(selected).getString("lo");
			dayType = object.getJSONObject("query").getJSONObject(selected).getString("dayType");
			
			result = "High:  " + hi + "\r\n"
					+ "Low:  " + lo + "\r\n"
					+  dayType + "\r\n";

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		
		return result;
		
	}
}
