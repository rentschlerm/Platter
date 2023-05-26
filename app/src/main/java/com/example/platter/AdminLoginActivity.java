package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    EditText username,password;
    Button loginbtn,registerbtn;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        registerbtn = (Button) findViewById(R.id.registerBtn);
        db = new MyDatabaseHelper(this);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminRegisterActivity.class);
                startActivity(intent);
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(AdminLoginActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Boolean checkuserpass = db.checkusernamepassword(user,pass);
                    if(checkuserpass==true)
                    {
                        Toast.makeText(AdminLoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), HomeScreenActivity.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(AdminLoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}