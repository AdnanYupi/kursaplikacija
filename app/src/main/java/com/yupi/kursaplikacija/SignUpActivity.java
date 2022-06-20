package com.yupi.kursaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {


    private EditText emailTxt;
    private EditText usernameTxt;
    private EditText passwordTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailTxt = findViewById(R.id.emailInput);
        usernameTxt = findViewById(R.id.usernameInput);
        passwordTxt = findViewById(R.id.passwordInput);


        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Sign up");
    }

    public void signUpAction(View view) {

        if (emailTxt.getText().toString().isEmpty()) {
            Toast.makeText(this, "Email can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!emailTxt.getText().toString().contains("@")) {
            Toast.makeText(this, "Email is not valid", Toast.LENGTH_SHORT).show();
            return;
        }

        if (usernameTxt.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passwordTxt.getText().toString().isEmpty()) {
            Toast.makeText(this, "Password can not be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if (passwordTxt.getText().toString().length() < 6) {
            Toast.makeText(this, "Password is to short", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}