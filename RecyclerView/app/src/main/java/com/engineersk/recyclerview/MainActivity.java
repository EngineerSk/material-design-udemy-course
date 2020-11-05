package com.engineersk.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public static final int NUMBER_OF_USERS = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Initializing users");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar materialToolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(materialToolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_id);

        List<User> users = new ArrayList<>();
        String[] names = new String[NUMBER_OF_USERS];
        String[] description = new String[NUMBER_OF_USERS];

        for(int i = 0; i<NUMBER_OF_USERS; ++i) {
            names[i] = "User " + (i + 1);
            description[i] = "Description " + (i + 1);
        }

        int[] images = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6,
                R.drawable.img7,
                R.drawable.img8,
                R.drawable.img9,
                R.drawable.img10,
                R.drawable.img11,
        };

        for(int i=0; i<NUMBER_OF_USERS; ++i)
            users.add(new User(names[i], description[i], images[i]));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(this, users));
    }
}