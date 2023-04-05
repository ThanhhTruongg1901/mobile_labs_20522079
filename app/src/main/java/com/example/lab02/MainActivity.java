package com.example.lab02;

import com.example.lab02.personal_salary;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    EditText FullName, GrossSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        FullName = (EditText) findViewById(R.id.FullName);
        GrossSalary = (EditText) findViewById(R.id.Gross);

        btnCalculate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = FullName.getText().toString();
                        Double sal = Double.parseDouble(GrossSalary.getText().toString());

                    }
                }

        );


    }
}