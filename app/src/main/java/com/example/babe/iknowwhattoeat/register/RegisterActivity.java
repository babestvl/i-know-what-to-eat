package com.example.babe.iknowwhattoeat.register;

import android.app.Activity;
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

import com.example.babe.iknowwhattoeat.data.User;
import com.example.babe.iknowwhattoeat.login.LoginActivity;
import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button registerButton;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = User.getInstance();
        progressDialog = new ProgressDialog(this);

        if(user.getFirebaseAuth().getCurrentUser() != null) {
            finish();
            startActivity(new Intent(getApplicationContext(), RandomActivity.class));
        }

        registerButton = (Button) findViewById(R.id.registerButton);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);
        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        registerButton.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void registerUser() {
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

        progressDialog.setMessage("Registering User...");
        progressDialog.show();

        user.getFirebaseAuth().createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful()) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), RandomActivity.class));
                } else {
                    Toast.makeText(RegisterActivity.this, "Could not register, please try again", Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == registerButton) {
            registerUser();
        }

        if(v == textViewSignin) {
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
