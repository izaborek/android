package com.example.newgame;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Canvas extends View {

    Paint paint;
    Path path;
    List<Float> listOfPoints;
    Integer pointToBeTouched = 1;
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
            canvas.drawPoint(listOfPoints.get(i),listOfPoints.get(i+1),paint);
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
        double absDist =  DistanceBetweenPoints(xPos,yPos,listOfPoints.get(pointToBeTouched-1),listOfPoints.get(pointToBeTouched));
        if (absDist <= 10) {
            ifDraw = true;
            ++pointToBeTouched;
        }
        if(ifDraw == true)
        {
            VerifyIfProperPointHasBeenTouched(xPos,yPos);
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

        private void cleanCanvas()
        {
            paint.reset();
            path.reset();
            //paint.setAntiAlias(true);
            paint.setColor(Color.RED); //to change later
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(15f); //change
            pointToBeTouched = 1;
            ifDraw = false;
        }

        private double DistanceBetweenPoints(float x1, float y1, float x2, float y2)
        {
            float distX = Math.abs(x1-x2);
            float distY = Math.abs(y1-y2);
            double absDist = Math.sqrt(distX * distX + distY * distY);
            return absDist;
        }

        private void VerifyIfProperPointHasBeenTouched(float x, float y)
        {
            for (int i = 0;i < pointsCount/2; i++) {
                if (i + 2 != pointToBeTouched) {
                    float xx = listOfPoints.get(i*2);
                    float yy = listOfPoints.get(i*2+1);
                    if (DistanceBetweenPoints(x, y, xx, yy) <= 10) {
                        if (i+1 == pointToBeTouched) {
                            ++pointToBeTouched;
                        } else {
                            Toast.makeText(this.getContext(),"Rozpocznij jeszcze raz!",Toast.LENGTH_LONG).show();
                            cleanCanvas();
                        }
                    }
                }
            }
        }


}
