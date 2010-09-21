package com.hairylogic.thumbpilot;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;


public final class Score extends Drawable {
	
	private static int _score = 0;
	private Paint _paint = new Paint();
	
	private final int X_LOCATION = 10;
	private final int Y_LOCATION = 20;
	private final int TEXT_SIZE = 25;
	private final int TEXT_COLOR = Color.WHITE;
	
	Score() { 
		// Set up the score painting style.
		_paint = new Paint(Paint.ANTI_ALIAS_FLAG | 
				Paint.UNDERLINE_TEXT_FLAG);
		
		// Set up the score text size.
		_paint.setTextSize(TEXT_SIZE);
		
		// Set skew
		_paint.setTextSkewX(0.13f);
		
		// Set the score text color.
		_paint.setColor(TEXT_COLOR);
	}
	
	@Override
	public void draw(Canvas canvas) {
		if (_score < 0)
			_paint.setColor(Color.RED);
		else _paint.setColor(Color.WHITE);
		
		canvas.drawText(Integer.toString(_score), X_LOCATION, Y_LOCATION, _paint);
	}
	
	/**
	 * Manually set the score here; even though it's the players score
	 * Perhaps later on down the line the player object could be passed.
	 * @param aNewScore
	 */
	public static void setScore(int aNewScore) {
		_score = aNewScore;
	}

	/**
	 * Get the score.
	 * @return - The score of the current player as an integer.
	 */
	public static int getScore() {
		return _score;
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
}
