package com.ZeroLinux5.todolist;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Get references to ui elements
		ListView myListView = (ListView) findViewById(R.id.myListView);
		final EditText myEditText = (EditText) findViewById(R.id.myEditText);
		
		//Create the array list of to do items
		final ArrayList<String> toDoItems = new ArrayList<String>();
		
		//create the array adapter to bind the array to the list view
		final ArrayAdapter<String> aa;
		
		aa = new ArrayAdapter<String> (this, 
									   android.R.layout.simple_list_item_1,
									   toDoItems);
		
		//Bind the adapter to the list view
		myListView.setAdapter(aa);
		
		myEditText.setOnKeyListener(new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if(event.getAction() == KeyEvent.ACTION_DOWN){
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
						toDoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
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
