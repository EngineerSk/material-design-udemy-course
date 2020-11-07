package com.engineersk.sliders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AppCompatSeekBar mAppCompatSeekBar;
    private TextView mAppCompatSeekBarValue, mRangeBar1Value;
    private TextView mRangeBar2LeftValue, mRangeBar2RightValue;
    private RangeBar mRangeBar1, mRangeBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppCompatSeekBar = findViewById(R.id.appcompat_seek_bar_id);
        mAppCompatSeekBarValue = findViewById(R.id.appcompat_seek_bar_value);

        mRangeBar1Value = findViewById(R.id.material_range_bar_value);
        mRangeBar1 = findViewById(R.id.material_range_bar1_id);

        mRangeBar2 = findViewById(R.id.material_range_bar2_id);
        mRangeBar2LeftValue = findViewById(R.id.material_range_bar2_left_value);
        mRangeBar2RightValue = findViewById(R.id.material_range_bar_right_value);

        mAppCompatSeekBar.setProgress(0);
        mAppCompatSeekBar.setKeyProgressIncrement(1);
        mAppCompatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d(TAG, "onProgressChanged: "+ i);
                mAppCompatSeekBarValue.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch: On Start tracking touch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch: On Stop tracking touch");
            }
        });

        mRangeBar1.setSeekPinByIndex(0);
        mRangeBar1.setRightThumbColor(getResources().getColor(R.color.design_default_color_secondary));
        mRangeBar1.setPinTextColor(getResources().getColor(R.color.white));
        mRangeBar1.setBarColor(getResources().getColor(R.color.design_default_color_secondary));
        mRangeBar1.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex,
                                              int rightPinIndex, String leftPinValue,
                                              String rightPinValue) {

                Log.d(TAG, "onRangeChangeListener: " + rightPinValue);
                mRangeBar1Value.setText(rightPinValue);
            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }
        });

        mRangeBar2.setSeekPinByIndex(0);
        mRangeBar2.setThumbColor(getResources().getColor(R.color.design_default_color_secondary));
        mRangeBar2.setBarColor(getResources().getColor(R.color.design_default_color_secondary));
        mRangeBar2.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int
                    rightPinIndex, String leftPinValue, String rightPinValue) {
                Log.d(TAG, "onRangeChangeListener: values "+leftPinValue+" "+rightPinValue);
                mRangeBar2LeftValue.setText(leftPinValue);
                mRangeBar2RightValue.setText(rightPinValue);
            }

            @Override
            public void onTouchStarted(RangeBar rangeBar) {

            }

            @Override
            public void onTouchEnded(RangeBar rangeBar) {

            }
        });
    }
}