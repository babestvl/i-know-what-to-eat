package com.example.babe.iknowwhattoeat.data;

import java.util.ArrayList;

public class LocalFoodDatabase {
    private ArrayList<Food> foodList;

    public LocalFoodDatabase() {
        foodList = new ArrayList<>();
        mockupFood();
    }

    private void mockupFood() {
        foodList.add(new Food("Pad Thai", "Noodle", "Thai", 35));
        foodList.add(new Food("Fry Rice", "Rice", "Thai", 30));
        foodList.add(new Food("Hamburger", "Fast food", "American", 99));
        foodList.add(new Food("Spaghetti", "Noodle", "Italian", 120));
        foodList.add(new Food("Yakisoba", "Noodle", "Japan", 50));
        foodList.add(new Food("Ribeye Steak", "Meat", "American", 200));
        foodList.add(new Food("Fry Chicken", "Fast food", "American", 28));
        foodList.add(new Food("Pizza", "Fast food", "Italian", 120));
        foodList.add(new Food("Salmon Steak", "Meat", "Japan", 120));
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}
