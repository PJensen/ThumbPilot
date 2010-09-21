package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Point;

public class BonusBlue extends Bonus {

	public BonusBlue(int aX, int aY) {
		super(aX, aY);
	}

	@Override
	public void doMove() {
		y = y + 1;
		x = x + ThumbPilot.mRandom.nextInt(2);
		x = x - ThumbPilot.mRandom.nextInt(2);
		_smoker.addSmoke(new Point(x, y));
	}

	@Override
	public void draw(Canvas canvas) {
		_smoker.draw(canvas);
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

	/**
	 * Static bitmap loaded at startup.
	 */
	static Bitmap mBitmap;
	
	private Smoker _smoker = new Smoker(50);
}
