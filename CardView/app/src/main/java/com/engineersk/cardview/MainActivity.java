package com.engineersk.cardview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CircularRevealCardView circularRevealCardView1 = findViewById(R.id.card_view1_id);
        circularRevealCardView1.setOnClickListener(this);
        CircularRevealCardView circularRevealCardView2 = findViewById(R.id.card_view2_id);
        circularRevealCardView2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.card_view1_id) {
            ImageView imageView = view.findViewById(R.id.image_1);
            Snackbar.make(imageView, "Angle view of gear clocks", Snackbar.LENGTH_LONG).show();
        }else if(view.getId() == R.id.card_view2_id){
            ImageView imageView = view.findViewById(R.id.image_2);
            Snackbar.make(imageView, "Industrial Gearbox", Snackbar.LENGTH_LONG).show();
        }
    }
}