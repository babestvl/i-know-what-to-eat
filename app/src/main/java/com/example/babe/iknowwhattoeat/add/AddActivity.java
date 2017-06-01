package com.example.babe.iknowwhattoeat.add;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.category.CategoryActivity;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;

public class AddActivity extends AppCompatActivity implements AddView {
    private EditText nameText;
    private EditText kindText;
    private EditText countryText;
    private EditText priceText;
    private AddPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Add Favourite Food");

        nameText = (EditText) findViewById(R.id.addName);
        kindText = (EditText) findViewById(R.id.addKind);
        countryText = (EditText) findViewById(R.id.addCountry);
        priceText = (EditText) findViewById(R.id.addPrice);
        presenter = new AddPresenter(this);
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

    public void addSubmit(View view) {
        presenter.addFood(nameText.getText().toString(), kindText.getText().toString(), countryText.getText().toString(), Double.parseDouble(priceText.getText().toString()));
        Toast.makeText(this, "Add new food", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, ProfileActivity.class));
    }
}
