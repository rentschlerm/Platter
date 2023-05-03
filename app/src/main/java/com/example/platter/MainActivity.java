package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_diner = findViewById(R.id.btn_Diner);
        Button btn_admin = findViewById(R.id.btn_Admin);

        btn_diner.setOnClickListener(this);
        btn_admin.setOnClickListener(this);

    }


        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.btn_Diner:
                    DinerLogin();
                    Toast.makeText(this,"Welcome to Platter!",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_Admin:
                    HomeScreen();
                    Toast.makeText(this,"Welcome Admin",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    public void HomeScreen(){
        Intent intent = new Intent(this,HomeScreen.class);
        startActivity(intent);
    }
    public void DinerLogin(){
        Intent intent = new Intent(this, DinerLogin.class);
        startActivity(intent);
    }

}
