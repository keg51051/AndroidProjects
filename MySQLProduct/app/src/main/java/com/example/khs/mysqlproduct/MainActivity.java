package com.example.khs.mysqlproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView idView;
    EditText productBox;
    EditText quantityBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idView = (TextView) findViewById(R.id.prodductId);
        productBox = (EditText) findViewById(R.id.productName);
        quantityBox = (EditText) findViewById(R.id.productQuantity);
    }

    public void addProduct(View view) {
        DataBaseHelper dbHandler = new DataBaseHelper(this, null, null, 1);
        int quantity =
                Integer.parseInt(quantityBox.getText().toString());
        Product product =
                new Product(productBox.getText().toString(), quantity);
            dbHandler.addProduct(product);
            Toast.makeText(this, "New Product Added", Toast.LENGTH_SHORT).show();
            productBox.setText("");
            quantityBox.setText("");
            idView.setText("");
    }

    public void lookupProduct(View view) {
        DataBaseHelper dbHandler = new DataBaseHelper(this, null, null, 1);
        Product product =
                dbHandler.findProduct(productBox.getText().toString());
        if (product == null) {
            idView.setText("Record : 0");
        } else {
            idView.setText("Record : " + String.valueOf(product.getId()));
            quantityBox.setText(String.valueOf(product.getQuantity()));
        }

    }

    public void removeProduct(View view) {
        DataBaseHelper dbHandler = new DataBaseHelper(this, null, null, 1);
        boolean result = dbHandler.deleteProduct(productBox.getText().toString());
        if (result) {
            productBox.setText("");
            quantityBox.setText("");
            idView.setText("");
            Toast.makeText(this, "Product Deleted", Toast.LENGTH_SHORT).show();
        } else {
            idView.setText("No Match Found");
        }
    }
}
