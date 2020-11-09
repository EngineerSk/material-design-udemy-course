package com.engineersk.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import java.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;

import static android.app.TimePickerDialog.*;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private static final String TAG = "MainActivity";

    private TextView mTimeText;
    private MaterialButton mPickTimeButton;
    private Calendar mCalendar;
    private TimePickerDialog mTimePickerDialog;
    private final boolean mTime24HourMode = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimeText = findViewById(R.id.time_text_view);
        mPickTimeButton = findViewById(R.id.time_button_id);

        mPickTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendar = Calendar.getInstance();
                int currentHour = mCalendar.get(Calendar.HOUR_OF_DAY);
                int currentMinute = mCalendar.get(Calendar.MINUTE);

                mTimePickerDialog = new TimePickerDialog(MainActivity.this,
                        MainActivity.this, currentHour, currentMinute, mTime24HourMode);
                mTimePickerDialog.setTitle("Time Picker");
                mTimePickerDialog.show();
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int numberOfHours, int numberOfMinutes) {
        int numberOfSeconds = mCalendar.get(Calendar.SECOND);

        String hour = (numberOfHours < 10)?"0"+numberOfHours:""+numberOfHours;
        String minutes = (numberOfMinutes < 10)?"0"+numberOfMinutes:""+numberOfMinutes;
        String seconds = (numberOfSeconds < 10) ? "0" + numberOfSeconds : "" + numberOfSeconds;

        mTimeText.setText(String.format("%s : %s : %s", hour, minutes, seconds));
    }
}