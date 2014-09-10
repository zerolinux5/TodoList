package com.ZeroLinux5.todolist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

public class ToDoListItemView extends TextView{
	private Paint marginPaint;
	private Paint linePaint;
	private int paperColor;
	private float margin;

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
		//Get the reference to the resource table
		Resources myResources = getResources();
		
		//Create the paintbrushes we will use
		marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		marginPaint.setColor(myResources.getColor(R.color.notepad_margin));
		linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		linePaint.setColor(myResources.getColor(R.color.notepad_lines));
		
		//get the background color and the margin widths
		paperColor = myResources.getColor(R.color.notepad_paper);
		margin = myResources.getDimension(R.dimen.notepad_margin);
	}
	
	@Override
	public void onDraw(Canvas canvas){
		//color as paper
		canvas.drawColor(paperColor);
		
		//draw ruled lines
		canvas.drawLine(0,0,0,getMeasuredHeight(), linePaint);
		canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);
		
		//draw margin
		canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);
		
		//move the text across from the margin
		canvas.save();
		canvas.translate(margin, 0);
		
		//Use the base text view to render the text
		super.onDraw(canvas);
		canvas.restore();
	}
}
