package com.example.khs.numberguessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button buttonL;
    Button buttonR;
    DataModel model;
    int points = 0;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new DataModel();
        buttonL = findViewById(R.id.buttonL);
        buttonL.setText(Integer.toString(model.getNum1()));

        buttonR = findViewById(R.id.buttonR);
        buttonR.setText(Integer.toString(model.getNum2()));

        result = findViewById(R.id.numberOfPoints);
    }

    public void onClick(View view) {
        if(points==5) {
            Toast.makeText(this, "You win the game!!", Toast.LENGTH_LONG).show();
            points = 0;
        } else {
            Button temp = (Button) view;
            String text = (String) temp.getText();
            String answer = Integer.toString(model.getAnswer());

            if (text.equals(answer)) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_LONG).show();
                points++;
                result.setText("Points: " + points);
            } else {
                Toast.makeText(this, "INCORRECT", Toast.LENGTH_LONG).show();
                points--;
                result.setText("Points: " + points);
            }
            model.setNum1();
            model.setNum2();
            while(true) {
                model.setNum2();
                if(model.getNum1()!=model.getNum2()) break;
            }
            model.setAnswer();
            buttonL.setText(Integer.toString(model.getNum1()));
            buttonR.setText(Integer.toString(model.getNum2()));
        }
    }
}
