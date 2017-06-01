package com.example.babe.iknowwhattoeat.recent;

import com.example.babe.iknowwhattoeat.data.User;

public class RecentPresenter {
    private User user;
    private RecentView view;

    public RecentPresenter(RecentView view) {
        this.view = view;
        user = User.getInstance();
    }

    public void getRecentFood() {
        view.setListView(user.getRecentFoods());
    }
}
