package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Passenger_Profile extends AppCompatActivity {
    //initiate
    TextView get_passengerprofile_cname,get_passengerprofile_user,getpassengerprofile_bal,get_passengerprofile_num;
    Button topup_transaction,travel_history,generate_qr;
    TextView back;
    ImageView qr_output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger__profile);

        get_passengerprofile_cname = findViewById(R.id.passenger_profile_cname);
        get_passengerprofile_user = findViewById(R.id.passenger_profile_user);
        getpassengerprofile_bal = findViewById(R.id.passenegr_profile_bal);
        get_passengerprofile_num = findViewById(R.id.passenger_profile_num);
        topup_transaction = findViewById(R.id.topup_transac);
        travel_history = findViewById(R.id.travel_history);
        generate_qr = findViewById(R.id.mobilenum_qr);
        qr_output = findViewById(R.id.show_qr);

        back = findViewById(R.id.back);

        //get values from passengerdashboard
        Intent i = getIntent();
        get_passengerprofile_user.setText(i.getStringExtra("user_name"));
        get_passengerprofile_cname.setText(i.getStringExtra("complete_name"));
        getpassengerprofile_bal.setText(i.getStringExtra("balance"));
        get_passengerprofile_num.setText(i.getStringExtra("mobile_number"));


        topup_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Passenger_Profile.this, TopUp_Transaction.class);
                i.putExtra("mobile_number",get_passengerprofile_num.getText().toString());
                startActivity(i);
                finish();

            }
        });

        travel_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Passenger_Profile.this,Travel_History.class);
                a.putExtra("mobile_number", get_passengerprofile_num.getText().toString());
                startActivity(a);
                finish();
            }
        });

        //back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Passenger_Profile.this, Passenger_Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        //mobilenum qr
        generate_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent a = new Intent(Passenger_Profile.this,Passenger_Mobile_QR.class);
                a.putExtra("mobile_number", get_passengerprofile_num.getText().toString());
                startActivity(a);
                finish();
            }
        });





    }
}