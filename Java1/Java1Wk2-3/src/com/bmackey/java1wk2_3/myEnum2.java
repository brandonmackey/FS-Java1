// Brandon Mackey
// Java 1 Week 2
// Term: 1405
// Full Sail University

package com.bmackey.java1wk2_3;

public enum myEnum2 {

	Nets		 ("Joe Johnson", "34 Pts"),
	Heat		 ("LeBron James", "29 Pts"),
	Trail_Blazers("LaMarcus Aldridge", "21 Pts"),
	Spurs		 ("Danny Green", "22 Pts");
	
	private String player;
	private String Stat;
	
	private myEnum2(String player, String Stat){
		
		this.player = player;
		this.Stat = Stat;
	}
	
	public String setplayer(){
		return player;
	}
	
	public String setStat(){
		return Stat;
	}
	
}
