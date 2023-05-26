package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_diner, btn_admin, btn_diner_proceed;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         btn_diner = findViewById(R.id.btn_Diner);
         btn_admin = findViewById(R.id.btn_Admin);
         btn_diner_proceed = findViewById(R.id.btn_Proceed);


        btn_diner.setOnClickListener(this);
        btn_admin.setOnClickListener(this);
        btn_diner_proceed.setOnClickListener(this);

        btn_diner_proceed.setVisibility(View.GONE);
    }


        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_Admin:
                    AdminLoginActivity();
                    Toast.makeText(this,"Welcome Admin",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_Proceed:
                    HomeScreen();
                    Toast.makeText(this,"Welcome!",Toast.LENGTH_SHORT).show();
                    break;

            }
            btn_diner.setVisibility(View.GONE);
            btn_admin.setVisibility(View.GONE);
        }
    public void HomeScreen(){
        Intent intent = new Intent(this, Food.class);
        startActivity(intent);
    }
    private void AdminLoginActivity()
    {
        Intent intent = new Intent(this,AdminLoginActivity.class);
        startActivity(intent);
    }

//    private void loadFragment(DinerLogin dinerlogin) {
//        FragmentManager fa = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fa.beginTransaction();
//        fragmentTransaction.replace(R.id.frame,dinerlogin);
//        fragmentTransaction.commit();
//    }



}
