package com.example.lab03_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class AllDataActivity extends AppCompatActivity {
    private DbAdapter dbAdapter;
    private Cursor cursor;
    ListView lvData;
    ArrayList<String> arrPeople;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);

        btnBack = (Button) findViewById(R.id.btnBack);

        dbAdapter = new DbAdapter(this);
        dbAdapter.open();
        arrPeople = getData();
        showData();


        btnBack.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AllDataActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }


    @SuppressLint("Range")
    private ArrayList<String> getData() {
        ArrayList<String> arrPeople = new ArrayList<>();

        cursor = dbAdapter.getAllPerson();
        while (cursor.moveToNext()) {
            arrPeople.add(cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_PHONE)) );
        }
        return arrPeople;
    }

    private void showData() {
        ListView lvUser = (ListView) findViewById(R.id.lvAllData);
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(AllDataActivity.this, android.R.layout.simple_list_item_1, arrPeople);
        lvUser.setAdapter(arrAdapter);
    }
}



