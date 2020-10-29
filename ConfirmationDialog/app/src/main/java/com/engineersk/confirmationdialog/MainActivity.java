package com.engineersk.confirmationdialog;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private MaterialAlertDialogBuilder mMaterialAlertDialogBuilder;
    private static final String[] levels = {"Easy","Medium", "Hard", "Very Hard"};
    private String mChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMaterialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        mMaterialAlertDialogBuilder.setTitle("Select the difficulty level");
        mMaterialAlertDialogBuilder.setSingleChoiceItems(levels, -1,
                (dialogInterface, i) -> mChoice = levels[i]);

        mMaterialAlertDialogBuilder.setPositiveButton("OK",
                (dialogInterface, i) -> Toast.makeText(MainActivity.this,
                        mChoice + " is the difficulty level selected",
                        Toast.LENGTH_LONG).show());

        mMaterialAlertDialogBuilder.setNegativeButton("CANCEL",
                (dialogInterface, i) -> Toast.makeText(MainActivity.this,
                        " Cancelling...", Toast.LENGTH_LONG).show());

        mMaterialAlertDialogBuilder.show();
    }
}