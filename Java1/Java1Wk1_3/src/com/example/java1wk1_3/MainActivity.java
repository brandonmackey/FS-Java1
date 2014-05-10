//Brandon Mackey 
//Java 1 
//Term: 1405 Week 1
//Full Sail University 

package com.example.java1wk1_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{
	
	
	
	// Global variable
	int HEADS = 1;
	int TAILS = 2;
	int coinFace; // coinFace is the Heads or Tails side of the coin
	Button button1;
	//TextView textView1;
	
	@Override
	  protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  
	  final TextView myText = (TextView) findViewById(R.id.textView1);
	 
	// Flip Button 
	final Button flipBT = (Button) findViewById(R.id.button1);
	flipBT.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(v != null){
				String test = myCoin.flip();
				System.out.println(test);
				myText.setText(test);
			}	
		}
	});
	
	
	} 
	
	public static class myCoin{
		final static int HEADS = 1;
		final int TAILS = 2;
		static int coinFace;
		
		public myCoin(){
			
		}
		
		// Algorithm for Determining the coin flip 
		public static String flip(){
			coinFace = (int) (Math.random() * 2) +1;	
			//System.out.println("test HERE!!!!");
			String faceSide;
			if (coinFace == HEADS){
				
				faceSide = "Heads";
			}else{
				faceSide = "Tails";
			}
			return faceSide;
		
		}
		
		public boolean isHeads(){
			return (coinFace == HEADS);
		}
		
		public boolean isTails(){
			return (coinFace == TAILS);
		}
			
	}



} ////////END//////////
