package com.engineersk.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRadioGroup = findViewById(R.id.radio_group_id);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radio_button1_id)
                        Toast.makeText(MainActivity.this,"Radio Button 1",
                                Toast.LENGTH_LONG).show();

                else if(i == R.id.radio_button2_id)
                        Toast.makeText(MainActivity.this, "Radio Button 2",
                                Toast.LENGTH_LONG).show();
            }
        });
    }
}