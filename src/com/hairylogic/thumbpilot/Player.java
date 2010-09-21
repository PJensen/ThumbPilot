package com.hairylogic.thumbpilot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

public final class Player extends Drawable implements IHasWidthHeight {
	
	public Player(int aX, int aY) {
		x = aX;
		y = aY;
		mPaint = new Paint();
		mPaint.setColor(Color.RED);
	}
	
	public static int x;
	public static int y;
	public static Paint mPaint;
	public final static int MAX_LIVES = 5;
	public static int mLives = MAX_LIVES;
	
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

	public int getHeight() {
		return 40;
	}

	public int getWidth() {
		return 40;
	}
}
