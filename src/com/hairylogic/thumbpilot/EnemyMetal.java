package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;

public class EnemyMetal extends Enemy {

	public EnemyMetal(int aX, int aY) {
		super(aX, aY);
	}

	@Override
	public void doMove() {
		this.y += 1;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, x, y, mPaint);
	}
	
	public int getHeight() {
		return mBitmap.getHeight();
	}

	public int getWidth() {
		return mBitmap.getWidth();
	}
	
	public static Bitmap mBitmap;
	
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
