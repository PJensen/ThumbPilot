package com.hairylogic.thumbpilot;

import java.util.Iterator;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/**
 * The screen draws to the canvas everything that is drawable in the game instance. 
 * Note that the screen is (and should not be) responsible for performing *any* game
 * logic operations. Also, note that screen extends View which allows us to do the
 * drawing.
 * @author dasm80x86
 */
public class Screen extends View {

	/**
	 * Constructor for the screen.
	 * @param context - The screen context.
	 */
	public Screen(Context context) {
		super(context);
	}
	
	/**
	 * Performs the drawing operations; 
	 * Note: Calling of this method is done by Android.
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		drawBonuses(canvas);
		
		ThumbPilot.mPlayer.draw(canvas);		
		
		invalidate();
	}

	/**
	 * Draw all bonuses on the canvas; synchronized to avoid threading issues.
	 * @param canvas - The canvas to draw on.
	 */
	private synchronized void drawBonuses(Canvas canvas) {
		// Draw all bonuses.
		Iterator<Bonus> iBonus = ThumbPilot.mBonuses.iterator();
		while (iBonus.hasNext()) {
			iBonus.next().draw(canvas);
		}
	}
}
