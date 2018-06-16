package com.example.disabledmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button checkButton;
    Button addButton;
    Button optionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkButton = (Button) findViewById(R.id.button2);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapsIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(mapsIntent);
            }
        });
        addButton = (Button) findViewById(R.id.button3);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(addIntent);
            }
        });
        optionButton = (Button) findViewById(R.id.button8);
        optionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent optionIntent = new Intent(getApplicationContext(), SetActivity.class);
                startActivity(optionIntent);
            }
        });
    }
}
