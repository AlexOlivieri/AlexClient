package com.example.alexclient;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		/*
		 * Test if the Account Registration has already been saved in the Preferences
		 * 
		 * - If already registered: go to the main screan
		 * - If not: registration phase
		 */
		final SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
		if(sharedPreferences.contains("user") && sharedPreferences.contains("password")){
			String user = sharedPreferences.getString("user", "User Not Found");
			String password = sharedPreferences.getString("password", "Password Not Found");
			
			//TODO: Add OAuth part
			
			
			Intent helloAndroidIntent = new Intent(RegisterActivity.this,
					MainActivity.class);
			startActivity(helloAndroidIntent);
		}else{
			final EditText username = (EditText) findViewById(R.id.user);
			final EditText password = (EditText) findViewById(R.id.password);
			
			final Button registerButton = (Button) findViewById(R.id.buttonNewRegistration);
			
			registerButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
						
					Editor editor = sharedPreferences.edit();
					editor.putString("user", username.toString());
					editor.putString("password", password.toString());
					editor.commit();
					
					username.setText("");
					password.setText("");
					
					//TODO: Add OAuth part
					
					
					Intent flagActivityIntent = new Intent(RegisterActivity.this,
							FlagActivity.class);

					startActivity(flagActivityIntent);
				}
			});
		}
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
