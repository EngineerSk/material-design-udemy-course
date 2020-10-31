package com.engineersk.imageslideshow;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar mMaterialToolbar;
    private ViewPager mViewPager;
    private SlideShowAdapter mSlideShowAdapter;
    private CircleIndicator mCircleIndicator;
    private Handler mHandler;
    private Runnable mRunnable;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMaterialToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mMaterialToolbar);

        mViewPager = findViewById(R.id.view_pager_id);
        mCircleIndicator = findViewById(R.id.circleIndicator_id);
        mSlideShowAdapter = new SlideShowAdapter(this);
        mViewPager.setAdapter(mSlideShowAdapter);
        mCircleIndicator.setViewPager(mViewPager);

        mHandler = new Handler();
        mRunnable = ()-> {
            int i = mViewPager.getCurrentItem();
            if(i == mSlideShowAdapter.images.length - 1)
                i = 0;
            else
                ++i;
            mViewPager.setCurrentItem(i, true);
        };
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.post(mRunnable);
            }
        }, 4000, 4000);
    }
}