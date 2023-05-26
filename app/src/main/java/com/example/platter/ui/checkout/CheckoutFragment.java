package com.example.platter.ui.checkout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.platter.Food;
import com.example.platter.R;
import com.example.platter.databinding.FragmentCheckoutBinding;

import java.util.ArrayList;

public class CheckoutFragment extends Fragment {

    private ListView checkoutListView;
    private ArrayAdapter<Food> checkoutAdapter;
    private static ArrayList<Food> checkoutList= new ArrayList<>();
    private FragmentCheckoutBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        checkoutListView = view.findViewById(R.id.checkoutListview);
        checkoutAdapter = new ArrayAdapter<>(requireContext(), R.layout.checkout_list, R.id.txtName, checkoutList);
        checkoutListView.setAdapter(checkoutAdapter);

        return view;
    }
    public static void addToCheckout(Food food) {
        if (checkoutList == null) {
            checkoutList = new ArrayList<>();
        }

        checkoutList.add(food);
    }
    private static class CheckoutListAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<Food> checkoutList;

        public CheckoutListAdapter(Context context, ArrayList<Food> checkoutList) {
            this.context = context;
            this.checkoutList = checkoutList;
        }

        @Override
        public int getCount() {
            return checkoutList.size();
        }

        @Override
        public Object getItem(int position) {
            return checkoutList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.checkout_list, parent, false);
                holder = new ViewHolder();
                holder.foodNameTextView = convertView.findViewById(R.id.txtName);
                holder.foodPriceTextView = convertView.findViewById(R.id.feeEachItem);
                holder.foodImageView = convertView.findViewById(R.id.imgFood);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Food food = checkoutList.get(position);

            holder.foodNameTextView.setText(food.getFood_Name());
            holder.foodPriceTextView.setText(food.getFood_Price());

            return convertView;
        }

        private static class ViewHolder {
            TextView foodNameTextView;
            TextView foodPriceTextView;
            ImageView foodImageView;
        }
        private Bitmap getBitmapFromByteArray(byte[] byteArray) {
            return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        }
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}