package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;

public class BonusBlue extends Bonus {

	public BonusBlue(int aX, int aY) {
		super(aX, aY);
	}

	@Override
	public void doMove() {
		y = y + 1;
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(mBitmap, x, y, mPaint);
	}

	@Override
	public int getOpacity() {
		return 0;
	}

	@Override
	public void setAlpha(int alpha) {
	}

	@Override
	public void setColorFilter(ColorFilter cf) {
	}

	static Bitmap mBitmap;
}
