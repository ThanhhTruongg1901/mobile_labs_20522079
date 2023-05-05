package com.example.lab03_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import com.example.lab03_sqlite.*;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DbAdapter dbAdapter;
    private Cursor cursor;
    ArrayList<String> arrPeople;

    Button btnAddLocal, btnQueryAll;
    EditText edtFullName, edtPhone;
    ListView lvData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddLocal = (Button) findViewById(R.id.AddLocal);
        btnQueryAll = (Button) findViewById(R.id.QueryAll);
        edtFullName = (EditText) findViewById(R.id.FullName);
        edtPhone = (EditText) findViewById(R.id.Phone);
        lvData = (ListView) findViewById(R.id.Data);
        arrPeople = new ArrayList<>();
        dbAdapter = new DbAdapter(this);

        btnAddLocal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = edtFullName.getText().toString();
                        String phone = edtPhone.getText().toString();
                        dbAdapter.open();
                        dbAdapter.createPerson(name,phone);
                        String info = name + " - " + phone;
                        arrPeople.add(info);
                        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrPeople);
                        lvData.setAdapter(adapter);

                    }
                }
        );

        btnQueryAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, AllDataActivity.class);
                        startActivity(intent);
                    }
                }

        );








    }
}