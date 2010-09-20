package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;

public class BonusGlass extends Bonus {

	public BonusGlass(int aX, int aY) {
		super(aX, aY);
	}

	@Override
	public void doMove() {
	}

	@Override
	public void draw(Canvas arg0) {
		arg0.drawBitmap(mBitmap, x, y, mPaint);
	}

	@Override
	public int getOpacity() {
		return 0;
	}

	@Override
	public void setAlpha(int arg0) { }

	@Override
	public void setColorFilter(ColorFilter arg0) { }
	
	/**
	 * This static bitmap *must* be loaded at startup.
	 */
	static Bitmap mBitmap;
}
