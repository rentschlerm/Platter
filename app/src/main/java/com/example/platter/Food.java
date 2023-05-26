package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Food extends AppCompatActivity {

    private int Food_ID;
    private String Food_Name;
    private String Food_Price;
    private byte[] Food_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen2);
    }

    public Food(int food_ID, String food_Name, String food_Price, byte[] food_Image) {
        Food_ID = food_ID;
        Food_Name = food_Name;
        Food_Price = food_Price;
        Food_Image = food_Image;
    }

    public Food() {
    }

    public int getFood_ID() {
        return Food_ID;
    }

    public void setFood_ID(int food_ID) {
        Food_ID = food_ID;
    }

    public String getFood_Name() {
        return Food_Name;
    }

    public void setFood_Name(String food_Name) {
        Food_Name = food_Name;
    }

    public String getFood_Price() {
        return Food_Price;
    }

    public void setFood_Price(String food_Price) {
        Food_Price = food_Price;
    }



    public byte[] getFood_Image() {
        return Food_Image;
    }

    public void setFood_Image(byte[] food_Image) {
        Food_Image = food_Image;
    }
}