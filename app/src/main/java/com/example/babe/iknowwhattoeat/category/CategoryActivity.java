package com.example.babe.iknowwhattoeat.category;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;
import com.example.babe.iknowwhattoeat.show.FoodActivity;

import java.util.ArrayList;

import static android.R.attr.value;

public class CategoryActivity extends AppCompatActivity implements CategoryView {
    private CategoryPresenter presenter;
    private ListView listView;
    private Adapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setTitle("Category");
        presenter = new CategoryPresenter(this);
        listView = (ListView) findViewById(R.id.allList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = (Food) listView.getItemAtPosition(position);
                Intent intent = new Intent(CategoryActivity.this, FoodActivity.class);
                intent.putExtra("name", food.getName());
                intent.putExtra("kind", food.getKind());
                intent.putExtra("country", food.getCountry());
                intent.putExtra("price", food.getPrice());
                startActivityForResult(intent, 0);
            }
        });
        presenter.getRecentFood();
    }

    @Override
    public void setListView(ArrayList<Food> foods) {
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        listView.setAdapter((ListAdapter) listAdapter);
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
