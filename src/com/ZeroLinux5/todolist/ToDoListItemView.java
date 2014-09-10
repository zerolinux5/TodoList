package com.ZeroLinux5.todolist;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

public class ToDoListItemView extends TextView{

	public ToDoListItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}
	
	public ToDoListItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	public ToDoListItemView(Context context) {
		super(context);
		init();
	}

	private void init(){
		
	}
	
	@Override
	public void onDraw(Canvas canvas){
		//Use the base text view to render the text
		super.onDraw(canvas);
	}
}
