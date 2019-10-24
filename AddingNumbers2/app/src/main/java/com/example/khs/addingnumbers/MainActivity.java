package com.example.khs.addingnumbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String KEY = "key";
    EditText firstNum;
    EditText secondNum;
    TextView result;
    Button btnAdd;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNum = (EditText) findViewById(R.id.txtNumber1);
        secondNum = (EditText) findViewById(R.id.txtNumber2);
        result = (TextView) findViewById(R.id.txtResult);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        if (savedInstanceState != null) {
            result.setText(savedInstanceState.getString(KEY));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(KEY, result.getText().toString());
    }

    public void onAdd(View view) {
        int num1, num2;
        num1 = Integer.parseInt((firstNum.getText().toString()));
        num2 = Integer.parseInt((secondNum.getText().toString()));
        int sum = num1 + num2;
        result.setText(Integer.toString(sum));
    }

    public void onClick(View view) {
         checkBox = (CheckBox) findViewById(R.id.checkBox);
        if (checkBox.isChecked()) {
            Toast.makeText(this, "Liked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Unliked", Toast.LENGTH_SHORT).show();
        }
    }
}
