package com.engineersk.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private Button mRaisedButton, mFlatButton;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRaisedButton = findViewById(R.id.raised_btn);
        mRaisedButton.setOnClickListener(view -> Toast.makeText(MainActivity.this,
                "Raised Button", Toast.LENGTH_SHORT).show());

        mFlatButton = findViewById(R.id.flat_btn);
        mFlatButton.setOnClickListener(view -> {
            Toast.makeText(this, "Flat Button", Toast.LENGTH_SHORT).show();
        });

        mFloatingActionButton = findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener((View view) -> {
            Toast.makeText(this, "Floating Action Button", Toast.LENGTH_SHORT).show();
        });
    }
}