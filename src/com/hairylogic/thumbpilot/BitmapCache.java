package com.hairylogic.thumbpilot;

import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Bitmap cache is designed to lazy load bitmaps on the getBitmap
 * method that takes an Integer.
 * 
 * @author dasm80x86
 */
public final class BitmapCache {
	
	/**
	 * Constructor for the BitmapCache
	 * @param aResources
	 */
	public BitmapCache(Resources aResources) {
		_resources = aResources;
		_cache = new HashMap<Integer, Bitmap>(); 
	}
	
	/**
	 * Lazy load and hopefully return a bitmap that matches the 
	 * passed identifier.
	 * @param aId
	 * @return
	 * @throws Exception
	 */
	public Bitmap getBitmap(Integer aId) throws Exception {
		
		if (_cache.containsKey(aId))
			return _cache.get(aId);
		else
			return 
				_cache.put(aId, BitmapFactory.decodeResource(_resources, aId));
	}

	/**
	 * Permanently link the Integer key to a bitmap value.
	 */
	private static HashMap<Integer, Bitmap> _cache;
	
	/**
	 * The main class has a link to resources; this gets passed in the
	 * constructor.
	 */
	private static Resources _resources; 
}
