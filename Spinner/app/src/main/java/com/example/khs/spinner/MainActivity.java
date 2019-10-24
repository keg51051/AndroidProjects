package com.example.khs.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Android");
        list.add("Iphone");
        list.add("Blackberry");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(getApplicationContext(), "A N D R O I D", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getApplicationContext(), "I P H O N E", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getApplicationContext(), "B B", Toast.LENGTH_SHORT).show();
                        break;
                        default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
