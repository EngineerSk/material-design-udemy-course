package com.engineersk.linearprogressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    private int i = 0;
    private Handler mHandler;
    private Runnable mRunnable;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setTitle("Linear Progress Dialog");
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.setProgress(0);
        mProgressDialog.setMax(100);
        mProgressDialog.show();

        mHandler = new Handler();
        mRunnable = () -> {
            i += 5;
            if(i<=100){
                mProgressDialog.setProgress(i);
            }else{
                mTimer.cancel();
                mProgressDialog.cancel();
                i = 0;
            }
        };

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(mRunnable);
            }
        }, 8000, 500);
    }
}