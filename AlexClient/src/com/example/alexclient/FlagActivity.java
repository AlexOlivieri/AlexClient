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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class FlagActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flag);
		
		final SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
		
		CheckBox obsceneFlag = (CheckBox) findViewById(R.id.checkbox_obscene);
		obsceneFlag.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//TODO Auto-generated method stub
				Editor editor = sharedPreferences.edit();
				editor.putBoolean("obscene", isChecked);
				editor.commit();
			}
		});
		
		CheckBox inappropriateFlag = (CheckBox) findViewById(R.id.checkbox_inappropriate);
		inappropriateFlag.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				//TODO Auto-generated method stub
				Editor editor = sharedPreferences.edit();
				editor.putBoolean("inappropriate", isChecked);
				editor.commit();
			}
		});
		
		final Button flagSettingsButton = (Button) findViewById(R.id.next_button);
		flagSettingsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent chainActivityIntent = new Intent(FlagActivity.this,
						GiftChainActivity.class);

				startActivity(chainActivityIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.flag, menu);
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
