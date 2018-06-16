package com.example.disabledmaps;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SetActivity extends AppCompatActivity {
    TextView textViewChoice;
    String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        textViewChoice = (TextView) findViewById(R.id.textView5);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb = (RadioButton)findViewById(checkedId);
            }
        });
    }


}
