package com.example.babe.iknowwhattoeat.recent;

import com.example.babe.iknowwhattoeat.data.Food;

import java.util.ArrayList;

public interface RecentView {
    public void setListView(ArrayList<Food> foods);
    public void initialize();
}
