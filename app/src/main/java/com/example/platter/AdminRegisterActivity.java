package com.example.platter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminRegisterActivity extends AppCompatActivity {

    EditText username,password,repassword;
    Button signup;
    TextView gotologin;
    MyDatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.signupbtn);
        gotologin = (TextView) findViewById(R.id.gotologin);

        db = new MyDatabaseHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                {
                    Toast.makeText(AdminRegisterActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    if (pass.equals(repass))
                    {
                        Boolean checkuser = db.checkusername(user);
                        if(checkuser == false)
                        {
                            boolean insert = db.insertDataAdmin(user,pass);
                            if(insert == true)
                            {
                                Toast.makeText(AdminRegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), AdminLoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(AdminRegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(AdminRegisterActivity.this, "User already exist! Please sign in ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(AdminRegisterActivity.this, "Password not matching!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdminLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}