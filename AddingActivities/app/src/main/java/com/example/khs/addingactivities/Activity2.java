package com.example.khs.addingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {
    EditText dataReceived;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        dataReceived = (EditText) findViewById(R.id.editText3);
        btnClose = (Button) findViewById(R.id.button2);

        Intent myLocalintent = getIntent();
        double num1 = myLocalintent.getDoubleExtra("key1", -1);
        double num2 = myLocalintent.getDoubleExtra("key2", -1);

        double result = num1 + num2;

        dataReceived.setText("Data received is \n"
        + "num1 = " + num1 + "\nnum2= " + num2
        + "\n\nresult = " + result);
    }

    public void onClose(View view) {
        finish();
    }
}
