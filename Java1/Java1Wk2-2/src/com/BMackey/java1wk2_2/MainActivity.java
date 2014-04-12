package com.BMackey.java1wk2_2;

import com.BMackey.java1wk2_2.MyJsonData;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
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
	

	static Context context;

	
	Context mContext;
	String[] mListItems;
	String[] mListItems2;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		//Initializing Constants
		mContext = this;
		mListItems = getResources().getStringArray(R.array.view_array);		
		
		// Create TextView for Daily Weather //
		final TextView textView1 = (TextView) findViewById(R.id.textView1);
		textView1.setTextSize(26);
		
		// Create TextView for Daily Weather //
		final TextView textView2 = (TextView) findViewById(R.id.textView2);
		textView2.setTextSize(20);
		
		//Grid Adapter //
		ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mListItems);
		
		
		// Create Grid View // 
		final GridView gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(gridAdapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				
				String selected = mListItems[position];
				
				String myStr = MyJsonData.readJSON(selected);

				textView2.setText(myStr);
				
				Toast.makeText(mContext, "You have selected " + mListItems[position] + " weather", Toast.LENGTH_LONG).show();

				
			}
		});
		
		
		// Spinner adapter //
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mListItems);
		spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		
		
		// Creating the Spinner // 
		Spinner viewSpinner =  (Spinner) findViewById(R.id.spinner1);
		viewSpinner.setAdapter(spinnerAdapter);
		viewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				
			
				String selected = mListItems[position];
				
				String myStr = MyJsonData.readJSON(selected);

				textView1.setText(myStr);
				Toast.makeText(mContext, "You have selected " + mListItems[position] + " weather", Toast.LENGTH_LONG).show();
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}
