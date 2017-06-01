package com.example.babe.iknowwhattoeat.data;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OnlineFoodDatabase {
    private ArrayList<Food> foodList;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private static OnlineFoodDatabase instance;

    public static OnlineFoodDatabase getInstance() {
        if(instance == null) {
            instance = new OnlineFoodDatabase();
        }
        return instance;
    }

    private OnlineFoodDatabase() {
        foodList = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        reference.child("food").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for(DataSnapshot child : children) {
                    foodList.add(child.getValue(Food.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addFoodToDatabase(Food food) {
        reference.child("food").push().setValue(food);
    }

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}
