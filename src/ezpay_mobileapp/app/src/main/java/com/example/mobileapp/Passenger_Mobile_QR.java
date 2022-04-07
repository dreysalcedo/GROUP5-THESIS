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

public class Passenger_Mobile_QR extends AppCompatActivity {

    Button btn_mobile_qr;
    TextView getMobileQR;
    ImageView show_MobileQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger__mobile__q_r);

        btn_mobile_qr = findViewById(R.id.btn_generate);
        getMobileQR = findViewById(R.id.tv_show_mobilenum);
        show_MobileQR = findViewById(R.id.show_mobile_qr);

        //pass  mobile_num
        Intent a = getIntent();
        getMobileQR.setText(a.getStringExtra("mobile_number"));

        btn_mobile_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    //Initialize bit matrix
                    BitMatrix bitMatrix = multiFormatWriter.encode( getMobileQR.getText().toString(),
                            BarcodeFormat.QR_CODE, 400, 400);

                    //Initialize barcode encoder
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    //Initialize bitmap
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                    //set bitmap on image view
                    show_MobileQR.setImageBitmap(bitmap);

                    //Initialize input manager
                    InputMethodManager manager = (InputMethodManager) getSystemService(
                            Context.INPUT_METHOD_SERVICE
                    );

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}