package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Confirm_Ticket extends AppCompatActivity {
    //initiate
    TextView transactionid, mobilenumber, starting, destination, distance, status, currentbalance, fare, newbalance,back;
    RequestQueue queue,queue2;
    Button confirm;
    RequestQueue balancequeue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_ticket);
        //find id
        transactionid = findViewById(R.id.tv_ct_transactionid);
        mobilenumber = findViewById(R.id.tv_ct_mobilenum);
        starting = findViewById(R.id.tv_ct_startloc);
        destination = findViewById(R.id.tv_ct_destination);
        distance = findViewById(R.id.tv_ct_distance);
        status = findViewById(R.id.tv_ct_status);
        currentbalance = findViewById(R.id.tv_ct_currentbalance);
        fare = findViewById(R.id.tv_ct_fare);
        newbalance = findViewById(R.id.tv_ct_newbalance);
        confirm = findViewById(R.id.btn_confirmticket);

        back = findViewById(R.id.back);
        //back button

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Confirm_Ticket.this, DriverDashboard.class);
                startActivity(intent);
                finish();
            }
        });

        //Confirm Ticket
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //update balance
                queue = Volley.newRequestQueue(Confirm_Ticket.this);
                StringRequest request = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/update.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Confirm_Ticket.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Confirm_Ticket.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("mobile_num", mobilenumber.getText().toString());
                        parameters.put("balance", newbalance.getText().toString());
                        return parameters;
                    }
                };
                queue.add(request);
           //update status
                queue2 = Volley.newRequestQueue(Confirm_Ticket.this);
                StringRequest request2 = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/updatestatus.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Confirm_Ticket.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Confirm_Ticket.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("transaction_id", transactionid.getText().toString());
                        parameters.put("status", "Paid");
                        return parameters;
                    }
                };
                queue2.add(request2);




            }


        });

        //get values from driverqr
        Intent confirm = getIntent();
        transactionid.setText(confirm.getStringExtra("transaction_id"));
        mobilenumber.setText(confirm.getStringExtra("mobile_num"));
        fare.setText(confirm.getStringExtra("fare"));
        starting.setText(confirm.getStringExtra("initial_location"));
        destination.setText(confirm.getStringExtra("destination"));
        status.setText(confirm.getStringExtra("status"));
        distance.setText(confirm.getStringExtra("distance"));

        //balancequeue
        balancequeue = Volley.newRequestQueue(Confirm_Ticket.this);
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/fetchbalance.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response1) {
                        try {
                            JSONObject obj = new JSONObject(response1);
                            JSONArray arr = obj.getJSONArray("value");
                            JSONObject d = arr.getJSONObject(0);
                            //String complete_name = topUpData.getString("complete_name");
                            //String mobile_num = topUpData.getString("mobile_num");
                            String balance = d.getString("balance");
                            Double parseBalance = Double.parseDouble(balance);
                            DecimalFormat df = new DecimalFormat(("#.##"));
                            parseBalance = Double.valueOf(df.format(parseBalance));
                            currentbalance.setText(parseBalance.toString());
                            //getTv_signup_name.setText(complete_name);
                            //getTv_signup_mobilenum.setText(mobile_num);
                            //new balance
                            double current_bal = Double.parseDouble(currentbalance.getText().toString());
                            double total_fare = Double.parseDouble(fare.getText().toString());
                            double new_bal = current_bal - total_fare;
                            newbalance.setText(String.valueOf(new_bal));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Confirm_Ticket.this, "Something went wrong", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mobile_num", mobilenumber.getText().toString());

                return parameters;
            }

        };
        balancequeue.add(stringRequest1);



    }//end of oncreate
}