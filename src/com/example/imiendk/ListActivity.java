package com.example.imiendk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ListActivity extends Activity {
	
	static {
		System.loadLibrary("prime-jni");
	}
	
	public native String getPrimesC(int numberMax);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		Button btGoJava = (Button) findViewById(R.id.btGo);
		Button btGoC = (Button) findViewById(R.id.btGoC);
		
		btGoJava.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView tvResult = (TextView) findViewById(R.id.tvResult);
				EditText etMaxPrime = (EditText) findViewById(R.id.etMax);
				
				int maxPrime = Integer.parseInt(etMaxPrime.getText().toString());
				
				tvResult.setText(ListActivity.this.getPrimesJava(maxPrime));
				
			}
		});
		
		btGoC.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TextView tvResult = (TextView) findViewById(R.id.tvResult);
				EditText etMaxPrime = (EditText) findViewById(R.id.etMax);
				
				int maxPrime = Integer.parseInt(etMaxPrime.getText().toString());
				
				tvResult.setText(ListActivity.this.getPrimesC(maxPrime));
				
			}
		});
		
		
	}
	
	private String getPrimesJava(int max)
	{
	       int i =0;
	       int num =0;
	       //Empty String
	       String  primeNumbers = "";

	       for (i = 1; i <= max; i++)         
	       { 		  	  
	          int counter=0; 	  
	          for(num =i; num>=1; num--)
		  {
	             if(i%num==0)
		     {
	 		counter = counter + 1;
		     }
		  }
		  if (counter ==2)
		  {
		     //Appended the Prime number to the String
		     primeNumbers = primeNumbers + i + " ";
		  }	
	       }	
	       return primeNumbers;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
