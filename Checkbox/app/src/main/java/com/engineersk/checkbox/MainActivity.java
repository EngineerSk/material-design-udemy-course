package com.engineersk.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.checkbox.MaterialCheckBox;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MaterialCheckBox mMaterialCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMaterialCheckBox = findViewById(R.id.checkbox_id);
        mMaterialCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Checkbox is Enabled",
                            Toast.LENGTH_LONG).show();
                }else
                    Toast.makeText(MainActivity.this, "Checkbox is Disabled",
                            Toast.LENGTH_LONG).show();
            }
        });
    }
}