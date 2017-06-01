package com.example.babe.iknowwhattoeat.add;

import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.data.OnlineFoodDatabase;

public class AddPresenter {
    private AddView view;
    private OnlineFoodDatabase database;

    public AddPresenter(AddView view) {
        this.view = view;
        database = OnlineFoodDatabase.getInstance();
    }

    public void addFood(String name, String kind, String country, double price) {
        Food food = new Food(name, kind, country, price);
        System.out.println(food.toString());
        database.addFoodToDatabase(food);
    }
}
