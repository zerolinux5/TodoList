package com.ZeroLinux5.todolist;

import java.util.ArrayList;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends ActionBarActivity implements
		NewItemFragment.OnNewItemAddedListener{
	private ArrayAdapter<String> aa;
	private ArrayList<String> toDoItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Get references to ui elements
		FragmentManager fm = getFragmentManager();
		ToDoListFragment toDoListFragment = (ToDoListFragment) fm.findFragmentById(R.id.TodoListFragment);
		
		toDoItems = new ArrayList<String>();
		
		// Create the array adapter to bind the array to the listview 
		aa = new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_1, toDoItems);
		
		//bind the array adapter to the listview
		toDoListFragment.setListAdapter(aa);
	}
	
	public void onNewItemAdded(String newItem) { 
		toDoItems.add(newItem); aa.notifyDataSetChanged();
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
