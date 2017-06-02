package com.example.babe.iknowwhattoeat.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.add.AddActivity;
import com.example.babe.iknowwhattoeat.category.CategoryActivity;
import com.example.babe.iknowwhattoeat.data.User;
import com.example.babe.iknowwhattoeat.login.LoginActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;
import com.example.babe.iknowwhattoeat.recent.RecentActivity;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView welcomeText;
    private Button buttonLogout;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");
        setContentView(R.layout.activity_profile);
        user = User.getInstance();

        if(user.getFirebaseAuth().getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }


        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        welcomeText = (TextView) findViewById(R.id.welcomeText);

        buttonLogout.setOnClickListener(this);
        welcomeText.setText("Welcome " + user.getFirebaseAuth().getCurrentUser().getEmail());
    }

    @Override
    public void onClick(View v) {
        if (v == buttonLogout) {
            user.getFirebaseAuth().signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public void toRandomPage(View view) {
        startActivity(new Intent(this, RandomActivity.class));
    }

    public void toCategoryPage(View view) {
        startActivity(new Intent(this, CategoryActivity.class));
    }

    public void toProfilePage(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void toAddPage(View view) {
        startActivity(new Intent(this, AddActivity.class));
    }

    public void toRecentPage(View view) {
        startActivity(new Intent(this, RecentActivity.class));
    }
}
