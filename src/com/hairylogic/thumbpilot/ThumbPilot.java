package com.hairylogic.thumbpilot;

import java.util.ArrayList;

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
import android.view.View;
import android.widget.Toast;

public class ThumbPilot extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BonusGlass.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_glass);
        BonusBlue.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_blue);
        BonusNuke.mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bonus_nuke);
        setContentView(mScreen = (new Screen(this)));
        mThread = new Thread(new MainThread());
        mBonuses.add(new BonusBlue(10, 10));
        mThread.start();
        // Toast.makeText(this, "Testing", 1).show();
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
    
    public static ArrayList<Bonus> mBonuses = new ArrayList<Bonus>();
    public static Player mPlayer = new Player(0, 0);
    public static Screen mScreen;
    public static Thread mThread; 
}	