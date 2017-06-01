package com.example.babe.iknowwhattoeat.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class User {
    private String email;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
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
        firebaseUser = firebaseAuth.getCurrentUser();
        email = firebaseAuth.getCurrentUser().getEmail();
        recentFoods = new ArrayList<>();
    }

    public FirebaseUser getUser() {
        return firebaseUser;
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public String getEmail() {
        return email;
    }

    public void addRecentFood(Food food) {
        recentFoods.add(food);
    }

    public ArrayList<Food> getRecentFoods() {
        return recentFoods;
    }
}
