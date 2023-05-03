package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_diner, btn_admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn_diner = findViewById(R.id.btn_Diner);
         btn_admin = findViewById(R.id.btn_Admin);

        btn_diner.setOnClickListener(this);
        btn_admin.setOnClickListener(this);

    }


        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_Diner:
                    loadFragment(new DinerLogin());
                    Toast.makeText(this,"Welcome to Platter!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_Admin:
                    HomeScreen();
                    Toast.makeText(this,"Welcome Admin",Toast.LENGTH_SHORT).show();
                    break;
            }
            btn_diner.setVisibility(View.GONE);
            btn_admin.setVisibility(View.GONE);
        }
    public void HomeScreen(){
        Intent intent = new Intent(this,HomeScreen.class);
        startActivity(intent);
    }

    private void loadFragment(DinerLogin dinerlogin) {
        FragmentManager fa = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fa.beginTransaction();
        fragmentTransaction.replace(R.id.frame,dinerlogin);
        fragmentTransaction.commit();
    }


}
