package com.example.platter;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;


public class MenuList extends AppCompatActivity {

    ListView list_View;
    ArrayList<Food> menuList;
    MenuListAdapter adapter = null;


    public static MyDatabaseHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        list_View = (ListView) findViewById(R.id.listView);
        menuList = new ArrayList<>();
        adapter = new MenuListAdapter(this, R.layout.menu_list, menuList);
        list_View.setAdapter(adapter);

        db = new MyDatabaseHelper(this);

        // get all data from sqlite
        Cursor cursor = db.getData("SELECT * FROM MenuList");
        menuList.clear();
        while (cursor.moveToNext()) {
            int Food_ID = cursor.getInt(0);
            String Food_Name = cursor.getString(1);
            String Food_Price = cursor.getString(3);
            byte[] Food_Image = cursor.getBlob(2);

            menuList.add(new Food(Food_ID,Food_Name, Food_Price, Food_Image ));
        }
        adapter.notifyDataSetChanged();


    }
}
