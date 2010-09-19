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
	public void run() {
		// This thread should be considered always running unless
		// stopped; 
		while (true) {
			
			// Apply the move operation to *all* bonuses. 
			Iterator<Bonus> iBonus = ThumbPilot.mBonuses.iterator();
			while (iBonus.hasNext()) {
				iBonus.next().doMove();
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
	 * Predefined amount of time to wait between applying logical 
	 * game operations.
	 */
	private final long THREAD_DELAY = 100L;
}
