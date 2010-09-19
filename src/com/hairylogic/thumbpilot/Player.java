package com.hairylogic.thumbpilot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

public class Player extends Drawable {
	
	// public Player() { }
	
	public Player(int aX, int aY) {
		this.x = aX;
		this.y = aY;
		mPaint = new Paint();
		mPaint.setColor(Color.RED);
	}
	
	public static int x;
	public static int y;
	public static Paint mPaint;
	
	@Override
	public void draw(Canvas canvas) {
		canvas.drawCircle(x, y, 40, mPaint);
	}

	@Override
	public int getOpacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAlpha(int alpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColorFilter(ColorFilter cf) {
		// TODO Auto-generated method stub
		
	}
}
