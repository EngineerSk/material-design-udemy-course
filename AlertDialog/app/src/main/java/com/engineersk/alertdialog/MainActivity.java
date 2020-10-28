package com.engineersk.alertdialog;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MaterialAlertDialogBuilder mAlertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Initialization");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlertDialogBuilder = new MaterialAlertDialogBuilder(this, R.style.AlertDialogTheme);
        mAlertDialogBuilder.setMessage("Discard Draft?");
        mAlertDialogBuilder.setPositiveButton("DISCARD",
                (dialogInterface, i) -> Toast.makeText(MainActivity.this,
                        "DISCARD MESSAGE", Toast.LENGTH_LONG).show());

        mAlertDialogBuilder.setNegativeButton("CANCEL",
                (dialogInterface, i) -> Toast.makeText(MainActivity.this,
                        "CANCEL MESSAGE", Toast.LENGTH_LONG).show());
        mAlertDialogBuilder.show();
    }
}