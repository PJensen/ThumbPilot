package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

public abstract class Enemy extends Actor {

	public Enemy(int aX, int aY, Bitmap aBitmap, Matrix aMatrix, Paint aPaint) {
		super(aX, aY, aBitmap, aMatrix, aPaint);
	}
}
