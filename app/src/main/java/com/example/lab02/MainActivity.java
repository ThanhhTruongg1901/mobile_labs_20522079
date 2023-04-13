package com.example.lab02;

import com.example.lab02.personal_salary;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCalculate;
    EditText FullName, GrossSalary;
   // TextView Result;
    ListView Result;
    ArrayList<String> arrResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = (Button) findViewById(R.id.buttonCalculate);
        FullName = (EditText) findViewById(R.id.FullName);
        GrossSalary = (EditText) findViewById(R.id.Gross);
       // Result = (TextView) findViewById(R.id.result);
        Result = (ListView) findViewById(R.id.Result);
        arrResult = new ArrayList<>();

        btnCalculate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = FullName.getText().toString();
                        int sal = Integer.parseInt(GrossSalary.getText().toString());
                        personal_salary ps = new personal_salary();
                        Double salary;
                        salary = ps.GetSalary(sal);
                        String items = name + " - " + "Net salary: " + salary;
                        arrResult.add(items);
                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrResult);
                        Result.setAdapter(adapter);
                       // Result.setText(name + " - " + "Net salary: " + salary);


                    }
                }

        );


    }
}