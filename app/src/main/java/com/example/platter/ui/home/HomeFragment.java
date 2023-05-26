package com.example.platter.ui.home;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.platter.Food;
import com.example.platter.MenuAddActivity;
import com.example.platter.MenuListAdapter;
import com.example.platter.MyDatabaseHelper;
import com.example.platter.R;
import com.example.platter.ui.checkout.CheckoutFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment{

    ListView list_View;
    ArrayList<Food> menuList;
    MenuListAdapter adapter = null;
    Button addmenubtn;
    public static MyDatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        list_View = (ListView) view.findViewById(R.id.menuListView);
        menuList = new ArrayList<>();
        adapter = new MenuListAdapter(requireContext(), R.layout.menu_list, menuList);
        list_View.setAdapter(adapter);

        addmenubtn = (Button) view.findViewById(R.id.addmenubtn);


        addmenubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuAddActivity.class);
                startActivity(intent);
            }
        });
        list_View.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the selected item from the menuList
                Food selectedFood = menuList.get(position);

                // Add the selected item to the checkout list
                CheckoutFragment.addToCheckout(selectedFood);

                // Optional: Provide some feedback to the user
                Toast.makeText(requireContext(), "Item added to checkout", Toast.LENGTH_SHORT).show();
            }
        });

        db = new MyDatabaseHelper(requireContext());

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
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}