package com.example.platter;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

/**
 * Created by Quoc Nguyen on 13-Dec-16.
 */

public class MenuList extends AppCompatActivity {

    ListView list_View;
    ArrayList<HomeScreenActivity> menuList;
    MenuListAdapter adapter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        list_View = (ListView) findViewById(R.id.listView);
        menuList = new ArrayList<>();
        adapter = new MenuListAdapter(this, R.layout.menu_list, menuList);
        list_View.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = MenuAddActivity.db.getData("SELECT * FROM MenuList");
        menuList.clear();
        while (cursor.moveToNext()) {
            int Food_ID = cursor.getInt(0);
            String Food_Name = cursor.getString(1);
            String Food_Price = cursor.getString(2);
            byte[] Food_Image = cursor.getBlob(3);

            menuList.add(new HomeScreenActivity(Food_ID,Food_Name, Food_Price, Food_Image ));
        }
        adapter.notifyDataSetChanged();


    }
}
