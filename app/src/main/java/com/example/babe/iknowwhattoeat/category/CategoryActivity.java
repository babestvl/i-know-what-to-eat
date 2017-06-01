package com.example.babe.iknowwhattoeat.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Category");
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
}
