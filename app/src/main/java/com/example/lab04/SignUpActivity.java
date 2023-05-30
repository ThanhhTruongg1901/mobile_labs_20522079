package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

                else if (validation(username, password) == false){
                    Toast toast = Toast.makeText(SignUpActivity.this, "UserName and password contain at least 6 characters.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }

                else {
                    EncryptedPassword(password);
                    databaseReference.child("users").child(username).child("fullname").setValue(fullname);
                    databaseReference.child("users").child(username).child("usename").setValue(username);
                    databaseReference.child("users").child(username).child("phone").setValue(phone);
                    databaseReference.child("users").child(username).child("password").setValue(password);

                    Toast toast = Toast.makeText(SignUpActivity.this, "Registration Successfully", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
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

    public Boolean validation(String username, String password ){
        if (username.length() < 6 || password.length() < 6){
            return false;
        }
        return true;


    }

    public void EncryptedPassword(String password){
        try{
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());
            byte messageDigest[] = digest.digest();

            StringBuffer MD5Hash = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
            {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while(h.length()<2)
                    h = "0" + h;
                MD5Hash.append(h);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

}