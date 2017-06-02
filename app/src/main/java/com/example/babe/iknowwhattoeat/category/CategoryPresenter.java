package com.example.babe.iknowwhattoeat.category;

import com.example.babe.iknowwhattoeat.data.OnlineFoodDatabase;

public class CategoryPresenter {
    private CategoryView view;
    private OnlineFoodDatabase database;

    public CategoryPresenter(CategoryView view) {
        this.view = view;
        database = OnlineFoodDatabase.getInstance();
    }


    public void getRecentFood() {
        view.setListView(database.getFoodList());
    }
}
