package com.example.testlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundleReceive = getIntent().getExtras();
        if(bundleReceive != null){
            User user = (User) bundleReceive.get("object_user");
            if(user != null ){
                System.out.println(user.getUserName());
            }
        }
    }
}