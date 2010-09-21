package com.hairylogic.thumbpilot;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;

public class ThumbPilot extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Load all bitmaps *extactly* one time to ensure efficiency.
        BonusGlass.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_glass);
        BonusBlue.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_blue);
        BonusNuke.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_nuke);
        EnemyMetal.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.enemy_metal);
        EnemyFire.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.enemy_fire);
        
        // Set the content view to point to the screen that we *just* created.
        setContentView(mScreen = (new Screen(this)));
        
        // Fire the main thread.
        if (!mThread.isAlive())
        	mThread.start();

        // Toast.makeText(this, "Testing", 1).show();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	Player.x = (int) event.getX();
    	Player.y = (int) event.getY();
    	return super.onTouchEvent(event);
    }
        
    /**
     * The screen that *everything* is drawn on.
     */
    public static Screen mScreen;
    
    /**
     * List of all enemies in the zone. invalidated or otherwise.
     */
    public static BlockingQueue<Enemy> mEnemies = new LinkedBlockingQueue<Enemy>();
    
    /**
     * List of all bonuses in the zone. invalidated or otherwise.
     */
    // public static ArrayList<Bonus> mBonuses = new ArrayList<Bonus>();
    
    public static BlockingQueue<Bonus> mBonuses = new LinkedBlockingQueue<Bonus>();	
    
    /**
     * The players object
     */
    public static Player mPlayer = new Player(0, 0);
    
    /**
     * The draw-able score tracking object.
     */
    public static Score mScore = new Score();
    	
    /**
     * The main-game thread; does all game logic etc.
     */
    public static Thread mThread = new Thread(new MainThread());
    
    /**
     * Not a fan of creating a new Random() object every time we need one.
     */
    public static Random mRandom = new Random();
}	