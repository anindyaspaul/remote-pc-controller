package com.example.jony.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View implements View.OnTouchListener {
    Paint paint = new Paint();
    Paint tpaint = new Paint();
    private double center_x, center_y,  bob_x, bob_y, len;
    private  double angle;
    private  double KE, PE, TE;
    int cnt = 0;

    public DrawView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(10);

        tpaint.setTextSize(75);
        tpaint.setTextAlign(Paint.Align.CENTER);

        angle = 0;
    }

    @Override
    public void onDraw(Canvas canvas)
    {

        //System.out.println("calling");
        canvas.drawColor(Color.WHITE);
        // get length or radious of line
        len = canvas.getHeight() * (2.7/4.0);
        //System.out.println("length :" + len);

        // draw center point
        center_x = canvas.getWidth()/2.0;
        center_y = 15;
        canvas.drawCircle((float) center_x, (float) center_y, 10, paint);

        //draw bob radious
        bob_x = center_x + len * Math.sin(angle);
        bob_y = center_y + len * Math.cos(angle);
        canvas.drawCircle((float) bob_x, (float) bob_y, 100, paint);

        // draw line
        canvas.drawLine((float) center_x, (float) center_y, (float) bob_x, (float) bob_y, paint);
        limit = center_x / len;

        //System.out.println(limit);
        if(cnt % 10 == 0){
            double te = 10 * 9.8 * len;
            TE = te * (1-Math.cos(limit));
            PE = te * (1-Math.cos(angle));
            KE = TE - PE;
            cnt = 0;
        }
        cnt++;


        canvas.drawText("PE : " + String.format("%.2f", PE), (float) center_x, (float) (len+300.0), tpaint);
        canvas.drawText("KE : " + String.format("%.2f", KE), (float) center_x, (float) (len+400.0), tpaint);
        canvas.drawText("TE : " + String.format("%.2f", TE), (float) center_x, (float) (len+500.0), tpaint);

    }

    double multiplier = 1;
    double dAngle = 0.004;
    double PI = Math.acos(-1);
    double limit = 2*PI;
    public void nextAngle(){
        angle += dAngle * multiplier;
        if(angle > limit){
            multiplier *= -1;
            angle = limit;
            //System.out.println(multiplier);
            //angle -= 360.0;
        }
        else if(angle < -limit){
            multiplier *= -1;
            angle = -limit;
        }
        System.out.println(angle);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}