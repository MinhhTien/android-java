package com.minhtienn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsername;
    private EditText edtPassword;
    private TextView tvNotAccYet;
    private Button btnSignIn;

    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        tvNotAccYet = findViewById(R.id.tvNotAccYet);
        btnSignIn = findViewById(R.id.btnSignIn);

        tvNotAccYet.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        //username
        if(TextUtils.isEmpty(edtUsername.getText().toString())) {
            edtUsername.setError(REQUIRE);
            return false;
        }

        //password
        if(TextUtils.isEmpty(edtPassword.getText().toString())) {
            edtPassword.setError(REQUIRE);
            return false;
        }

        //valid
        return true;
    }

    private void signIn() {
        // Invalid
        if(!checkInput()) {
            return;
        }

        //Start Main activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(R.id.btnSignIn == v.getId()) {
            signIn();
            return;
        }
        if(R.id.tvNotAccYet == v.getId()) {
            signUpForm();
        }
    }
}