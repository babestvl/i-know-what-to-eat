package com.example.babe.iknowwhattoeat.data;

public class Food {
    private String name;
    private String kind;
    private String country;
    private double price;

    public Food(String name, String kind, String country, double price) {
        this.name = name;
        this.kind = kind;
        this.country = country;
        this.price = price;
    }

    public Food() {

    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "\n" + price + " baht";
    }
}
