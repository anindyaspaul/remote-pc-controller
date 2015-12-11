
package com.example.jony.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity{
    DrawView drawView;
    final Handler myHandler = new Handler();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set full screen view
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //DrawingPanel drawingPanel = new DrawingPanel(this);
        //setContentView(drawingPanel);
        //drawingPanel.requestFocus();

        drawView = new DrawView(this);
        run();
    }

    public void run() {
        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                UpdateGUI();
            }
        }, 0, 10);
    }

    private void UpdateGUI() {
        myHandler.post(myRunnable);
    }

    final Runnable myRunnable = new Runnable() {
        public void run() {
            setContentView(drawView);
            drawView.nextAngle();
        }
    };
}

