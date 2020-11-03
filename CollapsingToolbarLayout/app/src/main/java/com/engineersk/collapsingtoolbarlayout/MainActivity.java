package com.engineersk.collapsingtoolbarlayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(materialToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FloatingActionButton floatingActionButton = findViewById(R.id.fab_id);
        floatingActionButton.setOnClickListener(view-> {
                        Snackbar.make(view,"Floating Action Button",
                                Snackbar.LENGTH_LONG).show();
                  });
    }
}