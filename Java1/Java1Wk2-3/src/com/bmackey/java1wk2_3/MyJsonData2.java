// Brandon Mackey
// Java 1 Week 2
// Term: 1405
// Full Sail University

package com.bmackey.java1wk2_3;

import org.json.JSONException;
import org.json.JSONObject;

public class MyJsonData2 {

	public static JSONObject createJson(){
		// create player JSONobject
		JSONObject playerObject = new JSONObject();
		
		// create enum JSONobject
				JSONObject queryObject = new JSONObject();
				try {
				// create player objects in enum
				for(myEnum2 player : myEnum2.values()){
					
					//create player object
					JSONObject playerInfo = new JSONObject();
					
					//add info to object
					playerInfo.put("player", player.setplayer());
					
					playerInfo.put("Stat", player.setStat());
									
					queryObject.put(player.name().toString(), playerInfo);
					
				}
				
				playerObject.put("query", queryObject);
				
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return playerObject;
			}
			
			public static String readJSON(String selected){
				
				String result, player, Stat;
				
				JSONObject object = createJson();
				
				try {
					player   = object.getJSONObject("query").getJSONObject(selected).getString("player");
					Stat  = object.getJSONObject("query").getJSONObject(selected).getString("Stat");
										
					result = "Player of the Game:  "   + "\r\n" + player   + "\r\n"
							+ "Points:  "    		   + Stat     + "\r\n";
							

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					result = e.toString();
				}
				
				return result;
				
			}
}