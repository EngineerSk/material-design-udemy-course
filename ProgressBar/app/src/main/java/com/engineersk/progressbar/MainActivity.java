package com.engineersk.progressbar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private Timer mTimer;
    private Handler mHandler;
    private Runnable mRunnable;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.progress_bar_id);
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setProgress(0);
        mProgressBar.setSecondaryProgress(0);
        mProgressBar.setMax(100);

        mHandler  = new Handler();
        mRunnable  = new Runnable() {
            @Override
            public void run() {
                if(++i <= 100){
                    mProgressBar.setProgress(i);
                    mProgressBar.setSecondaryProgress(i+10);
                }else {
                    mTimer.cancel();
                }
            }
        };

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(mRunnable);
            }
        }, 8000, 300);
    }
}