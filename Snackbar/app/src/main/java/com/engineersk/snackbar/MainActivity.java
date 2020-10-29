package com.engineersk.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton mFloatingActionButton;
    private Snackbar mSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFloatingActionButton = findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(view -> {
            mSnackbar = Snackbar.make(view, "Message sent", Snackbar.LENGTH_INDEFINITE);
            mSnackbar.setDuration(8000);
            mSnackbar.setAction("OK", view1 -> mSnackbar.dismiss());

            View v = mSnackbar.getView();
            v.setBackgroundColor(getResources().getColor(R.color.purple_500));

            TextView txt = v.findViewById(com.google.android.material.R.id.snackbar_text);
            txt.setTextColor(getResources().getColor(R.color.white));

            TextView action = v.findViewById(com.google.android.material.R.id.snackbar_action);
            action.setTextColor(getResources().getColor(R.color.cyan_A200));
            mSnackbar.show();
        });
    }
}