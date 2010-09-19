package com.hairylogic.thumbpilot;

/**
 * A Bonus is a "good" thing a player can collect; the various types
 * of bonuses inherit from this strictly abstract class.
 * @author dasm80x86
 */
public abstract class Bonus extends Actor {

	public Bonus(int aX, int aY) {
		super(aX, aY);
	}
}
