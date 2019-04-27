package com.example.newgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Canvas extends View {

    Paint paint;
    Path path;
    List<Float> listOfPoints;
    float screenWidth = this.getResources().getDisplayMetrics().widthPixels;
    float screenHeigth = this.getResources().getDisplayMetrics().heightPixels;
    boolean ifDraw = false;
    protected final Logger log = Logger.getLogger(getClass().getName()); //java.util.logging.Logger
    int pointsCount;

    public Canvas(Context context, AttributeSet attrs,Letter letter) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();

        this.listOfPoints = letter.getListOfPoints();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED); //to change later
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15f); //change
        pointsCount = letter.getPointsNumber(); //
        int drawableId=0;
        try {
            Class res = R.drawable.class;
            Field field = res.getField(letter.getName());
             drawableId = field.getInt(null);
        }
        catch (Exception e) {
            Log.e("MyTag", "Failure to get drawable id.", e);
        }

        setBackgroundResource(drawableId);

    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(30);
        paint.setColor(Color.GRAY);
        paint.setStrokeWidth(40f); //ch
        for (int i = 0;i < listOfPoints.size();i+=2) {
            canvas.drawPoint(canvas.getWidth()/2,listOfPoints.get(i+1),paint);
        }
        paint.setStrokeWidth(15f); //change
        paint.setAntiAlias(false);
        paint.setColor(Color.RED);
        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xPos = event.getX();
        float yPos = event.getY();

        log.log(Level.INFO, "Dotknięte współrzędne x:" + xPos + " Y:" + yPos, xPos );


        float distX = xPos - screenWidth/2;
        float distY = yPos - listOfPoints.get(3);
        double absDist = Math.sqrt(distX * distX + distY * distY);
        if (absDist <= 10) {
            ifDraw = true;
        }
        if(ifDraw == true)
        {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    path.moveTo(xPos, yPos);
                    return true;
                case MotionEvent.ACTION_MOVE:
                    path.lineTo(xPos, yPos);
                    break;
                case MotionEvent.ACTION_UP:
                    break;
                default:
                    return false;
            }
        }

            invalidate();
            return true;
        }


}
