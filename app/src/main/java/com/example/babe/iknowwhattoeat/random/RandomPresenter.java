package com.example.babe.iknowwhattoeat.random;

import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.data.LocalFoodDatabase;
import com.example.babe.iknowwhattoeat.data.OnlineFoodDatabase;
import com.example.babe.iknowwhattoeat.data.User;

public class RandomPresenter {
    private RandomView view;
    private OnlineFoodDatabase database;
    private User user;

    public RandomPresenter(RandomView view) {
        this.view = view;
        database = OnlineFoodDatabase.getInstance();
        user = User.getInstance();
    }

    public void randomFood() {
        int ran = (int) (Math.random() * database.getFoodList().size());
        Food food = database.getFoodList().get(ran);
        user.addRecentFood(food);
        view.setText(food);
    }
}
