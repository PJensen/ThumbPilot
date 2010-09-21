package com.hairylogic.thumbpilot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Paint.Cap;
import android.graphics.PathDashPathEffect.Style;
import android.graphics.drawable.Drawable;

public class Smoker extends Drawable {
	
	// The length of the smoke trail, does not change
	private final int _smokeTrailLength;
	
	// The style this smoke trail will be drawn in.
	private final Paint _smokePaint;
	
	private int _density;
	private int _densityCount = 0;
	
	final static int DEFAULT_DENSITY = 1;
	
	// The linked list that represents each point in the smoke trail.
	private LinkedList<Point> _smokeTrail = new LinkedList<Point>();
	
	
	// Experimental.
	private Path _smokePath = new Path();
	
	/**
	 * Constructor that takes the length that this smoketrail will forever be.
	 * @param aSmokeTrailLength
	 */
	public Smoker(int aSmokeTrailLength) {
		this(aSmokeTrailLength, DEFAULT_DENSITY);
	}
	
	public Smoker(int aSmokeTrailLength, int aDenisty)
		
	{
		_smokeTrailLength = aSmokeTrailLength;
		_smokePaint = new Paint();
		_smokePaint.setColor(Color.WHITE);
		_smokePaint.setStrokeCap(Cap.ROUND);
		_smokePaint.setAntiAlias(true);
		_smokePaint.setStrokeWidth(5);
		_smokeTrail = new LinkedList<Point>();
		_density = aDenisty;
	}
	
	/**
	 * Add a point to this smoke trail.
	 * @param aPoint
	 */
	public void addSmoke(Point aPoint) {
		if (_densityCount % _density == 0) {
			_smokeTrail.offer(aPoint);
			if (_smokeTrail.size() - 1 >= _smokeTrailLength)
				_smokeTrail.removeFirst();
			_densityCount = 0;
		}	
		_densityCount += 1;
	}

	/**
	 * Draw this smoke-trail in all of it's glory.
	 */
	@Override
	public void draw(Canvas canvas) {
		_smokePath = new Path();
		for (int index = 0; index < _smokeTrail.size(); ++index) {
			Point tmpPoint = _smokeTrail.get(index);
			if (index == 0)
				_smokePath.moveTo(tmpPoint.x, tmpPoint.y);
			else if (index == _smokeTrail.size() - 1)
				_smokePath.setLastPoint(tmpPoint.x, tmpPoint.y);
			else _smokePath.lineTo(tmpPoint.x, tmpPoint.y);
			canvas.drawPath(_smokePath, _smokePaint);
		}
	}

	@Override
	public int getOpacity() {
		return 0;
	}

	@Override
	public void setAlpha(int alpha) {	
	}

	@Override
	public void setColorFilter(ColorFilter cf) {	
	}
}
