package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.zxing.Result;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Driver_QR extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CAMERA = 0;
    TextView driver_gettransactionid, driver_fare, driver_mobilenum, driver_initloc, driver_destination, driver_status, driver_distance;
    private PreviewView previewView;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;
    private Button qrCodeFoundButton, confirmticket;
    private String qrCode;
    RequestQueue queue;
    TextView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver__q_r);
        previewView = findViewById(R.id.activity_main_previewView);
        driver_gettransactionid = findViewById(R.id.transaction_id);
        driver_fare = findViewById(R.id.fare);
        driver_mobilenum = findViewById(R.id.mobile_number);
        driver_initloc = findViewById(R.id.init_location);
        driver_destination = findViewById(R.id.destination);
        driver_status = findViewById(R.id.status);
        driver_distance = findViewById(R.id.distance);
        confirmticket = findViewById(R.id.confirm_ticket);
        qrCodeFoundButton = findViewById(R.id.activity_main_qrCodeFoundButton);
        qrCodeFoundButton.setVisibility(View.INVISIBLE);
        back = findViewById(R.id.back);


        //back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Driver_QR.this, DriverDashboard.class);
                startActivity(intent);
                finish();
            }
        });

        //qr code button
        qrCodeFoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //QR CODE

                //   Toast.makeText(getApplicationContext(), qrCode, Toast.LENGTH_SHORT).show();
                Log.i(Driver_QR.class.getSimpleName(), "QR Code Found: " + qrCode);
                driver_gettransactionid.setText(qrCode);
                queue = Volley.newRequestQueue(Driver_QR.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/fetchtransaction.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonobject = new JSONObject(response);
                                    JSONArray jsonarray = jsonobject.getJSONArray("transactions");
                                    JSONObject data = jsonarray.getJSONObject(0);
                                    String get_fare = data.getString("fare");
                                    String get_mobilenumber = data.getString("mobile_number");
                                    String get_initiallocation = data.getString("initial_location");
                                    String get_destination = data.getString("destination");
                                    String get_status = data.getString("status");
                                    String get_distance = data.getString("distance");
                                    //set text values to txtview
                                    driver_fare.setText(get_fare);
                                    driver_mobilenum.setText(get_mobilenumber);
                                    driver_initloc.setText(get_initiallocation);
                                    driver_destination.setText(get_destination);
                                    driver_status.setText(get_status);
                                    driver_distance.setText(get_distance);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Driver_QR.this, "Something went wrong", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("transaction_id", driver_gettransactionid.getText().toString());

                        return parameters;
                    }

                };
                queue.add(stringRequest);
                //end of fetch
            }

        });//end of qr btn

        //jump to confirm ticket
        confirmticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent confirm = new Intent(Driver_QR.this, Confirm_Ticket.class);
                    confirm.putExtra("transaction_id", driver_gettransactionid.getText().toString());
                    confirm.putExtra("fare", driver_fare.getText().toString());
                    confirm.putExtra("mobile_num", driver_mobilenum.getText().toString());
                    confirm.putExtra("initial_location", driver_initloc.getText().toString());
                    confirm.putExtra("destination", driver_destination.getText().toString());
                    confirm.putExtra("status", driver_status.getText().toString());
                    confirm.putExtra("distance", driver_distance.getText().toString());
                    startActivity(confirm);
                    finish();
                    Toast.makeText(Driver_QR.this, "PLease Confirm your Ticket", Toast.LENGTH_LONG).show();
                }

        });

        //camera
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        requestCamera();

    }// end of oncreate
    private void requestCamera() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                ActivityCompat.requestPermissions(Driver_QR.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST_CAMERA);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera();
            } else {
                Toast.makeText(this, "Camera Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void startCamera() {
        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindCameraPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {
                Toast.makeText(this, "Error starting camera " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }, ContextCompat.getMainExecutor(this));
    }
    private void bindCameraPreview(@NonNull ProcessCameraProvider cameraProvider) {
        previewView.setPreferredImplementationMode(PreviewView.ImplementationMode.SURFACE_VIEW);

        Preview preview = new Preview.Builder()
                .build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        preview.setSurfaceProvider(previewView.createSurfaceProvider());

        ImageAnalysis imageAnalysis =
                new ImageAnalysis.Builder()
                        .setTargetResolution(new Size(1280, 720))
                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                        .build();

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this), new QRCodeImageAnalyzer(new QRCodeFoundListener() {
            @Override
            public void onQRCodeFound(String _qrCode) {
                qrCode = _qrCode;
                qrCodeFoundButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void qrCodeNotFound() {
                qrCodeFoundButton.setVisibility(View.INVISIBLE);
            }

        }));

        Camera camera = cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, imageAnalysis, preview);
    }
}
