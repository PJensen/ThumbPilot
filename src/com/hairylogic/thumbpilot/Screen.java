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
	 * Note: Draw bonuses, Enemies, Player, then Score in *exactly* that order.
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// Draw all bonuses that are on the screen.
		drawBonuses(canvas);
		
		// Draw all enemies that are on the screen.
		drawEnemies(canvas);
		
		// Draw the player.
		ThumbPilot.mPlayer.draw(canvas);
		
		// Draw the score on top of it all.
		ThumbPilot.mScore.draw(canvas);
		
		// Invalidate the display.
		this.invalidate();
	}
	
	/**	
	 * Draw all bonuses on the canvas; synchronized to avoid threading issues.
	 * @param canvas - The canvas to draw on.
	 */
	private synchronized void drawBonuses(Canvas canvas) {
		// Draw all bonuses.
		Iterator<Bonus> iBonus = ThumbPilot.mBonuses.iterator();
		while (iBonus.hasNext()) {
			Bonus tmpBonus = iBonus.next();
			if (!tmpBonus.invalidated)
				tmpBonus.draw(canvas);
		}
	}
	
	/**	
	 * Draw all bonuses on the canvas; synchronized to avoid threading issues.
	 * @param canvas - The canvas to draw on.
	 */
	private synchronized void drawEnemies(Canvas canvas) {
		// Draw all bonuses.
		Iterator<Enemy> iEnemy = ThumbPilot.mEnemies.iterator();
		while (iEnemy.hasNext()) {
			Enemy tmpEnemy = iEnemy.next();
			if (!tmpEnemy.invalidated)
				tmpEnemy.draw(canvas);
		}
	}
}
