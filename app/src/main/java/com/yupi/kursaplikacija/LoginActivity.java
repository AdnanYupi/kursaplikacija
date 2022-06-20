package com.yupi.kursaplikacija;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String staticEmail = "test@test.com";
    private String staticPassword = "123456";

    private EditText emailTxt;
    private EditText passwordTxt;
    private TextView signUpUser;
    private Button loginBtn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailTxt = findViewById(R.id.emailInput);
        passwordTxt = findViewById(R.id.passwordInput);
        loginBtn = findViewById(R.id.loginBtn);
        progressBar = findViewById(R.id.progressBar);
        signUpUser = findViewById(R.id.signUpUser);


        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Login");

    }

    public void loginAction(View view) {

        String emailInput = emailTxt.getText().toString();
        String passwordInput = passwordTxt.getText().toString();

        if (!emailInput.equals(staticEmail)) {
            Toast.makeText(this, "Email not correct", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!passwordInput.equals(staticPassword)) {
            Toast.makeText(this, "Password not correct", Toast.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    public void createUserAction(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}