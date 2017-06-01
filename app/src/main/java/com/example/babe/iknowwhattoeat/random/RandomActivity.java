package com.example.babe.iknowwhattoeat.random;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.category.CategoryActivity;
import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.data.LocalFoodDatabase;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;

import java.util.ArrayList;

public class RandomActivity extends AppCompatActivity implements RandomView {

    private EditText nameText;
    private EditText priceText;
    private RandomPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        setTitle("Random");
        nameText = (EditText) findViewById(R.id.nameText);
        priceText = (EditText) findViewById(R.id.priceText);
        nameText.setEnabled(false);
        priceText.setEnabled(false);
        presenter = new RandomPresenter(this);
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

    public void randomFood(View view) {
        presenter.randomFood();
    }

    public void setText(Food food) {
        nameText.setText("Name: " + food.getName());
        priceText.setText("Price: " + (food.getPrice()+" Baht"));
    }
}
