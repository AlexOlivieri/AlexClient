package com.example.alexclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class GiftChainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gift_chain);
		
		//TODO Add OAuth part
		

		AutoCompleteTextView chainSearchView = (AutoCompleteTextView) findViewById(R.id.gift_chain_search);
		//TODO Substitute the list of chains with the list of chains from the DB
		String[] chains= {"ciao", "caio", "hello"};		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chains);
		chainSearchView.setAdapter(adapter);
		
		//TODO add each selected chain to a list and show it dynamically
	
		final Button nextButton = (Button) findViewById(R.id.next_button);
		
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//TODO save the list of gift into the preferences
				
				Intent mainActivityIntent = new Intent(GiftChainActivity.this,
						MainActivity.class);

				startActivity(mainActivityIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gift_chain, menu);
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
