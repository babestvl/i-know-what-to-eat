package com.example.babe.iknowwhattoeat.show;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.category.CategoryActivity;
import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;


public class FoodActivity extends AppCompatActivity implements FoodView {
    private FoodPresenter presenter;
    private EditText textName;
    private EditText textKind;
    private EditText textCountry;
    private EditText textPrice;
    private String foodName;
    private String foodKind;
    private String foodCountry;
    private Double foodPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        presenter = new FoodPresenter(this);
        textName = (EditText) findViewById(R.id.textName);
        textKind = (EditText) findViewById(R.id.textKind);
        textCountry = (EditText) findViewById(R.id.textCountry);
        textPrice = (EditText) findViewById(R.id.textPrice);
        foodName = getIntent().getStringExtra("name");
        foodKind = getIntent().getStringExtra("kind");
        foodCountry = getIntent().getStringExtra("country");
        foodPrice = getIntent().getDoubleExtra("price", 0);
        presenter.setEditText();
        setTitle(foodName);
        setText();
    }

    public void select(View view) {
        Food food = new Food(foodName, foodKind, foodCountry, foodPrice);
        Toast.makeText(this, "You Select " + foodName, Toast.LENGTH_LONG).show();
        presenter.update(food);
        startActivity(new Intent(this, CategoryActivity.class));
    }

    public void setText() {
        textName.setText(foodName);
        textKind.setText(foodKind);
        textCountry.setText(foodCountry);
        textPrice.setText("" + foodPrice);
    }

    @Override
    public void setDefaultEditText() {
        textName.setEnabled(false);
        textKind.setEnabled(false);
        textCountry.setEnabled(false);
        textPrice.setEnabled(false);
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
