package com.example.khs.addingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity1 extends AppCompatActivity {
    EditText txtNum1;
    EditText txtNum2;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum1 = (EditText) findViewById(R.id.editText);
        txtNum2 = (EditText) findViewById(R.id.editText2);
        btnAdd = (Button) findViewById(R.id.button);
    }

    public void onAdd(View view) {
        Double n1 = Double.parseDouble(txtNum1.getText().toString());
        Double n2 = Double.parseDouble(txtNum2.getText().toString());

        Intent myintent = new Intent(this, Activity2.class);

        myintent.putExtra("key1", n1);
        myintent.putExtra("key2", n2);

        startActivity(myintent);
    }
}
