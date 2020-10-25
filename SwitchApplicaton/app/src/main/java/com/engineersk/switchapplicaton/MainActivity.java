package com.engineersk.switchapplicaton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private SwitchMaterial mSwitchMaterial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitchMaterial = findViewById(R.id.switch_id);
        mSwitchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    Toast.makeText(MainActivity.this, "Switch is ON",
                            Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Switch is OFF",
                            Toast.LENGTH_LONG).show();
            }
        });
    }
}