package com.engineersk.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "MainActivity";
    public static final String DATE_PICKER_TAG = "DATE PICKER";

    private TextView mDateTextView;
    private MaterialButton mDatePickerButton;
    private DatePickerDialog mDatePickerDialog;
    private DatePickerDialog mFinalPickerDialog;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDateTextView = findViewById(R.id.date_text_view);
        mDatePickerButton = findViewById(R.id.date_picker_button);

        mDatePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mCalendar = Calendar.getInstance();
                int currentDay = mCalendar.get(Calendar.DAY_OF_MONTH);
                int currentMonth = mCalendar.get(Calendar.MONTH);
                int currentYear = mCalendar.get(Calendar.YEAR);
                mDatePickerDialog = DatePickerDialog.newInstance(MainActivity.this,
                        currentYear, currentMonth, currentDay);
                mDatePickerDialog.setTitle("Date Picker");
                mDatePickerDialog.dismissOnPause(false);
                mDatePickerDialog.showYearPickerFirst(true);
                mDatePickerDialog.show(getSupportFragmentManager(), DATE_PICKER_TAG);
            }
        });

        mFinalPickerDialog = (DatePickerDialog) getSupportFragmentManager()
                .findFragmentByTag(DATE_PICKER_TAG);

        if(mFinalPickerDialog != null)
            mFinalPickerDialog.setOnDateSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int year, int month, int day) {
        mDateTextView.setText(String.format("%s/%s/%s", day, ++month, year));
    }
}