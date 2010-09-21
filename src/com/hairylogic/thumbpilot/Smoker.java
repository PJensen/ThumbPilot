package com.hairylogic.thumbpilot;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Paint.Cap;
import android.graphics.drawable.Drawable;

public class Smoker extends Drawable {
	
	// The length of the smoke trail, does not change
	private final int _smokeTrailLength;
	
	// The style this smoke trail will be drawn in.
	private Paint _smokePaint;
	
	private int _density;
	private int _densityCount = 0;
	final static int DEFAULT_DENSITY = 1;
	private int _parentWidth;
	
	// The linked list that represents each point in the smoke trail.
	private LinkedBlockingQueue<Point> _smokeTrail = new LinkedBlockingQueue<Point>();
	
	public Smoker(int aSmokeTrailLength, int aDenisty, int aWidth)
	{
		// Set the length of the smoke trail.
		_smokeTrailLength = aSmokeTrailLength;
		_smokePaint = new Paint();
		_smokePaint.setColor(Color.WHITE);
		_smokePaint.setStrokeCap(Cap.SQUARE);
		_smokePaint.setStrokeWidth(aWidth / 4);			
		_smokeTrail = new LinkedBlockingQueue<Point>();
		_density = aDenisty;
		_parentWidth = aWidth;	
	}
	
	/**
	 * Add a point to this smoke trail.
	 * @param aPoint
	 */
	public void addSmoke(Point aPoint) {
		if (_densityCount % _density == 0) {
			_smokeTrail.offer(aPoint);
			if (_smokeTrail.size() - 1 >= _smokeTrailLength)
				_smokeTrail.poll();
			_densityCount = 0;
		}	
		_densityCount += 1;
	}

	/**
	 * Draw this smoke-trail in all of it's glory.
	 */
	@Override
	public void draw(Canvas canvas) {
		
		Iterator<Point> iPoints = _smokeTrail.iterator();
		while (iPoints.hasNext()) {
			Point tmpPoint = iPoints.next();
			tmpPoint.x += (_parentWidth / 2);
			canvas.drawPoint(tmpPoint.x, tmpPoint.y, _smokePaint);
		}
		
		/*
		for (int index = 0; index < _smokeTrail.size();++index) {
			Point tmpPoint = _smokeTrail.
			tmpPoint.x += (_parentWidth / 2);
			canvas.drawPoint(tmpPoint.x, tmpPoint.y, _smokePaint);
		}*/
		
		/*
		_smokePath = new Path();
		for (int index = 0; index < _smokeTrail.size(); ++index) {
			Point tmpPoint = _smokeTrail.get(index);
			tmpPoint.x += (_parentWidth / 2);
			if (index == 0)
				_smokePath.moveTo(tmpPoint.x, tmpPoint.y);
			else if (index == _smokeTrail.size() - 1)
				_smokePath.setLastPoint(tmpPoint.x, tmpPoint.y);
			else _smokePath.lineTo(tmpPoint.x, tmpPoint.y);
			canvas.drawPath(_smokePath, _smokePaint);
		}
		*/
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
