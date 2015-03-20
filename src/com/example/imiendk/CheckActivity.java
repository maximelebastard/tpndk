package com.example.imiendk;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends Activity {
	
	static {
		System.loadLibrary("prime-jni");
	}
	
	public native int isPrimeC(int number);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check);
		
		EditText etNumber = (EditText) this.findViewById(R.id.inputNumber);
		Button btCheckC = (Button) this.findViewById(R.id.btCheckPrimeC);
		Button btCheckJava = (Button) this.findViewById(R.id.btCheckPrimeJava);
				
		btCheckC.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText etNumber = (EditText) CheckActivity.this.findViewById(R.id.inputNumber);
				int number = Integer.parseInt(etNumber.getText().toString());
				if(CheckActivity.this.isPrimeC(number) == 1)
				{
					Toast.makeText(CheckActivity.this, "C dit que c'est premier", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(CheckActivity.this, "C dit que c'est pas premier", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		btCheckJava.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText etNumber = (EditText) CheckActivity.this.findViewById(R.id.inputNumber);
				int number = Integer.parseInt(etNumber.getText().toString());
				if(CheckActivity.this.isPrimeJava(number))
				{
					Toast.makeText(CheckActivity.this, "Java dit que c'est premier", Toast.LENGTH_SHORT).show();
				}
				else
				{
					Toast.makeText(CheckActivity.this, "Java dit que c'est pas premier", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
	}
	
	private boolean isPrimeJava(int number)
	{
	    for(int i=2;i<number;i++) {
	        if(number%i==0)
	            return false;
	    }
	    return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
