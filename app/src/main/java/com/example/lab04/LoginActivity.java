package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lab04-login-default-rtdb.firebaseio.com");
    Button btnLogIn;
    EditText edtUserName, edtPassword;
    TextView txtsignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogIn = (Button) findViewById(R.id.login);
        edtUserName = (EditText)  findViewById(R.id.username);
        edtPassword = (EditText) findViewById(R.id.password);
        txtsignup = (TextView) findViewById(R.id.signup);


        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = edtUserName.getText().toString();
                String Password = edtPassword.getText().toString();

                if (UserName.isEmpty() || Password.isEmpty()){
                    Toast.makeText(LoginActivity.this,"User Name or Password is incorrect", Toast.LENGTH_SHORT).show();
                }
                else{



                }
            }
        });


        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));

            }
        });


    }
}