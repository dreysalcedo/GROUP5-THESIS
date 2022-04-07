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

public class Passenger_Generate_QR extends AppCompatActivity {

    Button qr_generate;
    TextView gettransaction_id, back;
    ImageView qr_output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_generate_qr);
        //find id
        gettransaction_id = findViewById(R.id.tv_qr_transactionid);
        qr_generate = findViewById(R.id.btn_generate);
        qr_output = findViewById(R.id.showqr);
        back = findViewById(R.id.back);


        //pass username
        Intent i = getIntent();
        gettransaction_id.setText(i.getStringExtra("transaction id"));

        //back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Passenger_Generate_QR.this, Passenger_Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        //generate button
        qr_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    //Initialize bit matrix
                    BitMatrix bitMatrix = multiFormatWriter.encode( gettransaction_id.getText().toString(),
                            BarcodeFormat.QR_CODE, 400, 300);

                    //Initialize barcode encoder
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    //Initialize bitmap
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

                    //set bitmap on image view
                    qr_output.setImageBitmap(bitmap);

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