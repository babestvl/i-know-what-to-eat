package com.example.babe.iknowwhattoeat.recent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.babe.iknowwhattoeat.R;
import com.example.babe.iknowwhattoeat.category.CategoryActivity;
import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.profile.ProfileActivity;
import com.example.babe.iknowwhattoeat.random.RandomActivity;

import java.util.ArrayList;
import java.util.List;

public class RecentActivity extends AppCompatActivity implements RecentView {
    private RecentPresenter presenter;
    private ListView listView;
    private Adapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent);
        setTitle("Recent Food");
        presenter = new RecentPresenter(this);
        initialize();
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

    @Override
    public void setListView(ArrayList<Food> foods) {
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        listView.setAdapter((ListAdapter) listAdapter);
    }

    @Override
    public void initialize() {
        listView = (ListView) findViewById(R.id.recent);
        presenter.getRecentFood();
    }
}
