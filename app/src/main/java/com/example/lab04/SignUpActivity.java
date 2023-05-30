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

public class SignUpActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lab04-login-default-rtdb.firebaseio.com");
    EditText edtFullName, edtPhone, edtUserName, edtPassword;
    Button btnSignUp;
    TextView txtLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtFullName = (EditText) findViewById(R.id.FullName);
        edtPhone = (EditText)  findViewById(R.id.Phone);
        edtUserName = (EditText) findViewById(R.id.UserName);
        edtPassword = (EditText) findViewById(R.id.password);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        txtLogIn = (TextView) findViewById(R.id.backLogIn);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = edtFullName.getText().toString();
                String phone = edtPhone.getText().toString();
                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                if(fullname.isEmpty() || username.isEmpty() || phone.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }

                else {
                    databaseReference.child("users").child(username).child("fullname").setValue(fullname);
                    databaseReference.child("users").child(username).child("usename").setValue(username);
                    databaseReference.child("users").child(username).child("phone").setValue(phone);
                    databaseReference.child("users").child(username).child("password").setValue(password);

                    Toast.makeText(SignUpActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });


        txtLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}