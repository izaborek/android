package com.example.newgame;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/**,
 * Klasa odpowiedzialna  jest za wyświetlenie tutorialu gry w formie animacji
 * */
public class PathView extends View
{
    Path path;
    Paint paint;
    float length;

    public PathView(Context context)
    {
        super(context);
        //init();
    }

    public PathView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
       // init();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        //init();
    }

    public void init()
    {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15f);
        paint.setStyle(Paint.Style.STROKE);

        setBackgroundResource(R.drawable.literal);

        path = new Path();
        path.moveTo(750, 200);
        path.lineTo(750, 850);
        path.lineTo(1200, 850);
        //path.lineTo(200, 300);
        //path.lineTo(350, 300);

        // Measure the path
        PathMeasure measure = new PathMeasure(path, false);
        length = measure.getLength();

        float[] intervals = new float[]{length, length};

        ObjectAnimator animator = ObjectAnimator.ofFloat(PathView.this, "phase", 1.0f, 0.0f);
        animator.setDuration(6000);
        animator.start();

    }

    //is called by animtor object
    public void setPhase(float phase)
    {
        Log.d("pathview","setPhase called with:" + String.valueOf(phase));
        paint.setPathEffect(createPathEffect(length, phase, 0.0f));
        invalidate();//will calll onDraw
    }

    private static PathEffect createPathEffect(float pathLength, float phase, float offset)
    {
        return new DashPathEffect(new float[] { pathLength, pathLength },
                Math.max(phase * pathLength, offset));
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        paint.setTextSize(30);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(40f);
        c.drawPoint(750, 200, paint);
        c.drawPoint(750, 850, paint);
        c.drawPoint(1200, 850, paint);

        paint.setTextSize(15f);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(15f);

        c.drawPath(path, paint);

    }


}