package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Driver_Profile extends AppCompatActivity {

    TextView get_driver_cname,get_driver_user,get_driver_num,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver__profile);

        get_driver_cname = findViewById(R.id.driver_profie_cname);
        get_driver_user = findViewById(R.id.driver_profile_user);
        get_driver_num = findViewById(R.id.driver_profile_num);

        back = findViewById(R.id.back);
        //back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Driver_Profile.this, DriverDashboard.class);
                startActivity(intent);
                finish();
            }
        });


        //get values from driverdashboard
        Intent a = getIntent();
        get_driver_user.setText(a.getStringExtra("user_name"));
        get_driver_cname.setText(a.getStringExtra("complete_name"));
        get_driver_num.setText(a.getStringExtra("mobile_number"));
    }
}