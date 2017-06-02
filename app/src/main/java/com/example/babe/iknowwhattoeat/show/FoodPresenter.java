package com.example.babe.iknowwhattoeat.show;

import com.example.babe.iknowwhattoeat.data.Food;
import com.example.babe.iknowwhattoeat.data.User;

public class FoodPresenter {
    private FoodView view;
    private User user;

    public FoodPresenter(FoodView view) {
        this.view = view;
        user = User.getInstance();
    }

    public void update(Food food) {
        user.addRecentFood(food);
    }

    public void setEditText() {
        view.setDefaultEditText();
    }
}
