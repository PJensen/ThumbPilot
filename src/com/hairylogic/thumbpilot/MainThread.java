package com.hairylogic.thumbpilot;

import java.util.Iterator;

/**
 * The thread responsible for performing all logical game operations; 
 * like detecting collisions, calling move methods for various actors.
 * Note: Nothing in this thread should call draw. 
 * @author dasm80x86
 */
public final class MainThread implements Runnable {

	/**
	 * Implements Runnable
	 */
	public synchronized void run() {
		// This thread should be considered always running unless
		// stopped; 
		while (true) {
			// TODO: Level based calculation and addition of enemies and
			
			try {
			if (ThumbPilot.mRandom.nextInt(500) < 10)
			ThumbPilot.mBonuses.add(new BonusBlue(
					ThumbPilot.mRandom.nextInt(ThumbPilot.mScreen.getWidth() - 100) + 50, 10));
			} catch(Exception ex) { }
			
			if (ThumbPilot.mBonuses.size() > 0) {
			// 	Apply the move operation to *all* bonuses. 
				Iterator<Bonus> iBonus = ThumbPilot.mBonuses.iterator();
				while (iBonus.hasNext()) {
					iBonus.next().doMove();
				}
			}
			
			// TODO: Apply the move operation to *all* enemies.
			// TODO: Detected collisions between enemies and bonuses
			// TODO: Detect collisions between player and bonuses
			// TODO: Detected collisions between player and enemies
			
			// Wait a predefined amount of time.
			try { Thread.sleep(THREAD_DELAY); } 
			catch (InterruptedException e) { }
		}
	}
	
	/**
	 * The current level that the player is on; 
	 * Defaults to one.
	 */
	public int mLevel = 0x0001;
	
	/**
	 * The maximum level the player can reach.
	 */
	private final int MAX_LEVEL = 2;
	
	/**
	 * Predefined amount of time to wait between applying logical 
	 * game operations.
	 */
	private final long THREAD_DELAY = 10L;
}
