package com.example.babe.iknowwhattoeat.data;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class User {
    private FirebaseAuth firebaseAuth;
    private ArrayList<Food> recentFoods;

    private static User instance;

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    private User() {
        firebaseAuth = FirebaseAuth.getInstance();
        recentFoods = new ArrayList<>();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void addRecentFood(Food food) {
        recentFoods.add(food);
    }

    public ArrayList<Food> getRecentFoods() {
        return recentFoods;
    }
}
