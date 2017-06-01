package com.example.babe.iknowwhattoeat.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.data.User;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;
import com.example.babe.iknowwhattoeat.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignup;
    private User user;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog = new ProgressDialog(this);
        user = User.getInstance();

        if(user.getUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), RandomActivity.class));
        }

        loginButton = (Button) findViewById(R.id.loginButton);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);

        loginButton.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    public void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Login User...");
        progressDialog.show();

        user.getFirebaseAuth().signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), RandomActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Could not login don't have an account or wrong email/password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton) {
            userLogin();
        }

        if(v == textViewSignup) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }


}
