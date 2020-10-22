package com.engineersk.textfield;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();

    private EditText mUsernameField;
    private EditText mPasswordField;
    private TextInputLayout mUsernameTextInputLayout;
    private TextInputLayout mPasswordTextInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsernameField = findViewById(R.id.username_textField);
        mPasswordField = findViewById(R.id.password_textField);

        mUsernameTextInputLayout = findViewById(R.id.username_textInputLayout);
        mUsernameField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(mUsernameField.getText().toString().isEmpty()){
                    mUsernameTextInputLayout.setErrorEnabled(true);
                    mUsernameTextInputLayout.setError("please enter your username");
                }else{
                    mUsernameTextInputLayout.setErrorEnabled(false);
                }
            }
        });

        mUsernameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(mUsernameField.getText().toString().isEmpty()){
                    mUsernameTextInputLayout.setErrorEnabled(true);
                    mUsernameTextInputLayout.setError("Please enter your username!!!");
                }else{
                    mUsernameTextInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPasswordTextInputLayout = findViewById(R.id.password_textInputLayout);
        mPasswordTextInputLayout.setCounterEnabled(true);
        mPasswordTextInputLayout.setCounterMaxLength(8);
    }
}