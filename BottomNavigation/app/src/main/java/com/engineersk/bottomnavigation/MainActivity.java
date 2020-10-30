package com.engineersk.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView mBottomNavigationView;
    private TextView mDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottom_navigation_view);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mDisplayText = findViewById(R.id.display_txt);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.nearby_id){
            mDisplayText.setText(getResources().getText(R.string.near_by));
            return true;
        }
        if(id == R.id.fav){
            mDisplayText.setText(getResources().getText(R.string.favourite));
            return true;
        }
        if(id == R.id.recent_id){
            mDisplayText.setText(getResources().getText(R.string.recent));
            return true;
        }

        return false;
    }
}