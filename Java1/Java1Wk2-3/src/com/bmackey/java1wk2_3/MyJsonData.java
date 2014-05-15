// Brandon Mackey
// Java 1 Week 2
// Term: 1405
// Full Sail University


package com.bmackey.java1wk2_3;

import org.json.JSONException;
import org.json.JSONObject;

public class MyJsonData {
	
	public static JSONObject createJson(){
		// create score JSONobject
		JSONObject scoreObject = new JSONObject();
		
		// create enum JSONobject
		JSONObject queryObject = new JSONObject();
		try {
		// create score objects in enum
		for(myEnum score : myEnum.values()){
			
			//create score object
			JSONObject scoreInfo = new JSONObject();
			
			//add info to object
			scoreInfo.put("firstQRT", score.setfirstQRT());
			
			scoreInfo.put("secondQRT", score.setsecondQRT());
		
			scoreInfo.put("thirdQRT", score.setthirdQRT());
			
			scoreInfo.put("fourthQRT", score.setfourthQRT());
			
			scoreInfo.put("finalScore", score.setfinalScore());
			
			queryObject.put(score.name().toString(), scoreInfo);
			

		}
		
		scoreObject.put("query", queryObject);
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scoreObject;
	}
	
	public static String readJSON(String selected){
		
		String result, firstQRT, secondQRT, thirdQRT, fourthQRT, finalScore;
		
		JSONObject object = createJson();
		
		try {
			firstQRT   = object.getJSONObject("query").getJSONObject(selected).getString("firstQRT");
			secondQRT  = object.getJSONObject("query").getJSONObject(selected).getString("secondQRT");
			thirdQRT   = object.getJSONObject("query").getJSONObject(selected).getString("thirdQRT");
			fourthQRT  = object.getJSONObject("query").getJSONObject(selected).getString("fourthQRT");
			finalScore = object.getJSONObject("query").getJSONObject(selected).getString("finalScore");
			
			result = "1st QTR:  "      + firstQRT   + "\r\n"
					+ "2nd QTR:  "     + secondQRT  + "\r\n"
					+ "3rd QTR:  "     + thirdQRT   + "\r\n"
					+ "4nd QTR:  "     + fourthQRT  + "\r\n"
					+ "Final Score:  " + finalScore + "\r\n";

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.toString();
		}
		
		return result;
		
	}

}
