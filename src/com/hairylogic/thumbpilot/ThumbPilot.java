package com.hairylogic.thumbpilot;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class ThumbPilot extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Load all bitmaps *extactly* one time to ensure efficiency.
        BonusGlass.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_glass);
        BonusBlue.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_blue);
        BonusNuke.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_nuke);
        
        // Set the content view to point to the screen that we *just* created.
        setContentView(mScreen = (new Screen(this)));
        
        mBonuses.add(new BonusBlue(10, 10));
        
        // Fire the main thread.
        mThread.start();
        
        // Toast.makeText(this, "Testing", 1).show();
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	Player.x = (int) event.getX();
    	Player.y = (int) event.getY();
    	return super.onTouchEvent(event);
    }
    
    @Override
    protected void onStart() {
    	// mThread.start();
    	super.onStart();
    }
    
    @Override
    protected void onStop() {
    	// mThread.stop();
    	super.onStop();
    }
    
    /**
     * The screen that *everything* is drawn on.
     */
    public static Screen mScreen;
    
    /**
     * List of all enemies in the zone. invalidated or otherwise.
     */
    public static ArrayList<Enemy> mEnemies = new ArrayList<Enemy>();
    
    /**
     * List of all bonuses in the zone. invalidated or otherwise.
     */
    public static ArrayList<Bonus> mBonuses = new ArrayList<Bonus>();
    
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