package com.hairylogic.thumbpilot;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/**
 * The Actor class represents all objects other than the player and should
 * be considered an actor in the game system.
 * 
 * @author dasm80x86
 */
public abstract class Actor extends Drawable {
		
	/**
	 * Explicit constructor sets both the x and y coordinate for a new
	 * game system Actor.
	 * @param aX - The x-coordinate for the new Actor.
	 * @param aY - The y-coordinate for the new Actor.
	 * @param aBitmap - 
	 * @param aMatrix
	 * @param aPaint
	 */
	public Actor(int aX, int aY, Bitmap aBitmap, Matrix aMatrix, Paint aPaint) {
		this.x = aX;
		this.y = aY;
		this.mPaint = aPaint;
		this.mBitmap = aBitmap;
		this.mMatrix = aMatrix;
	}
		
	/**
	 * Undefined method of movement for this Actor.
	 */
	public abstract void doMove();
		
	/**
	 * Set the x-coordinate for this Actor.
	 * @param x The x-coordinate for this Actor.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the x-coordinate for this Actor.
	 * @return The x-coordinate for this Actor.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Set y-coordinate for this Actor.
	 * @param y the 
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Get the y-coordinate for this Actor.
	 * @return The y-coordinate for this Actor.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * The x-coordinate for this Actor.
	 */
	private int x;
	
	/**
	 * The y-coordinate for this Actor.
	 */
	private int y;

	protected Matrix mMatrix;
	protected Paint mPaint;
	protected Bitmap mBitmap;
}
