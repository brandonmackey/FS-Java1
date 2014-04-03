//Brandon Mackey 
//Java 1 
//Term: 1404 Week 1
//Full Sail University 

package com.bmackey.java1wk1;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends Activity implements OnClickListener {
	
	
	
	// Global variable
	TextView billAmountTV, totalTipTV;
	EditText totalBillET;
	Button weakServiceBtn;
	Button averageServiceBtn;
	Button greatServiceBtn;
	String amountStr;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
   
     //create layout
     LinearLayout mainLayout = new LinearLayout(this);
     mainLayout.setOrientation(LinearLayout.VERTICAL);
     LayoutParams mainLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
     mainLayout.setLayoutParams(mainLayoutParam);
     
     //Text View label
     billAmountTV = new TextView(this);
     LayoutParams textParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
     billAmountTV.setLayoutParams(textParams);
     billAmountTV.setText("Bill Amount");
     billAmountTV.setTextSize(35.0f);
     mainLayout.addView(billAmountTV);
     
     // Text Field 
     totalBillET = new EditText(this);
     LayoutParams textParams2 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
     totalBillET.setLayoutParams(textParams2);
     totalBillET.setHint("Example: 100 Round Up");
     totalBillET.setInputType(InputType.TYPE_CLASS_NUMBER);
     mainLayout.addView(totalBillET);
     
     // Tip % buttons
    
     // 10%
     weakServiceBtn = new Button(this);
     weakServiceBtn.setLayoutParams(textParams2);
     weakServiceBtn.setText("10%");
     mainLayout.addView(weakServiceBtn);
     weakServiceBtn.setOnClickListener(this);
     
     // 15%
     averageServiceBtn = new Button(this);
     averageServiceBtn.setLayoutParams(textParams2);
     averageServiceBtn.setText("15%");
     mainLayout.addView(averageServiceBtn);
     averageServiceBtn.setOnClickListener(this);

     
     // 20%
     greatServiceBtn = new Button(this);
     greatServiceBtn.setLayoutParams(textParams2);
     greatServiceBtn.setText("20%");
     mainLayout.addView(greatServiceBtn);
     greatServiceBtn.setOnClickListener(this);
  
     
     // TextView Total Tip Amount 
     totalTipTV = new TextView(this);
     LayoutParams textParams3 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
     totalTipTV.setLayoutParams(textParams3);
     totalTipTV.setText("Total Tip");
     totalTipTV.setTextSize(35.0f);
     mainLayout.addView(totalTipTV);
 
     
     setContentView(mainLayout);
     
     
 }




	@SuppressLint("ShowToast")
	@Override
	public void onClick(View v) {
		
		Button seletedButton = (Button) v;
		
		if (seletedButton == weakServiceBtn)
		{
			if ( totalBillET.length() == 0)
			{
				Toast alert = Toast.makeText(this, "Please Enter Bill Amount & Round Up", Toast.LENGTH_LONG);
				alert.show();
			}
			else
			{
				amountStr = totalBillET.getText().toString();
				Float amountF = Float.valueOf(amountStr) * 0.1f;
				String totalStr = String.valueOf(amountF);
				amountF = Float.parseFloat(totalStr);
				totalTipTV.setText(totalStr);
			}
		}
		else if (seletedButton == averageServiceBtn) 
		{
			if ( totalBillET.length() == 0)
			{
				Toast alert = Toast.makeText(this, "Please Enter Bill Amount & Round Up", Toast.LENGTH_LONG);
				alert.show();
			}
			else
			{
				amountStr = totalBillET.getText().toString();
				Float amountF = Float.valueOf(amountStr) * 0.15f;
				String totalStr = String.valueOf(amountF);
				amountF = Float.parseFloat(totalStr);
				totalTipTV.setText(totalStr);
			}
		}
		else if (seletedButton == greatServiceBtn)
		{	
			if ( totalBillET.length() == 0)
			{
				Toast alert = Toast.makeText(this, "Please Enter Bill Amount & Round Up", Toast.LENGTH_LONG);
				alert.show();
			}
			else
			{
				amountStr = totalBillET.getText().toString();
				Float amountF = Float.valueOf(amountStr) * 0.2f;
				String totalStr = String.valueOf(amountF);
				amountF = Float.parseFloat(totalStr);
				totalTipTV.setText(totalStr);
			}
		}
	}
}
