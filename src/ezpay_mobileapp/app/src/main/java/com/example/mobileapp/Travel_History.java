package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Travel_History extends AppCompatActivity {
    ListView listView;
    TravelAdapter adapter;
    ImageView back;
    TextView show_mobile_num;
    public static ArrayList<TravelData> TravelDataArrayList = new ArrayList<>();
    String url = "http://sdffea.com/Thesis/travelhistory.php";
    TravelData travelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_history);
        listView = findViewById(R.id.myTravelHistory);
        adapter = new TravelAdapter(this, TravelDataArrayList);
        listView.setAdapter(adapter);
        //find id
        show_mobile_num = findViewById(R.id.travel_showmobile_num);
        //pass  mobile_num
        Intent a = getIntent();
       show_mobile_num.setText(a.getStringExtra("mobile_number"));

        retrieveData();
    }
// retrieve from traveldata class database
    public void retrieveData() {

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        TravelDataArrayList.clear();
                        try {

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("Success");
                            JSONArray jsonArray = jsonObject.getJSONArray("afcs_transactions");

                            if (success.equals("1")) {

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("transaction_id");
                                    String fare = object.getString("fare");
                                    String mobile_number = object.getString("mobile_number");
                                    String init_location = object.getString("initial_location");
                                    String destination = object.getString("destination");
                                    String status = object.getString("status");
                                    String distance = object.getString("distance");

                                    travelData = new TravelData(id, fare, mobile_number, init_location, destination, status, distance);

                                    TravelDataArrayList.add(travelData);
                                    adapter.notifyDataSetChanged();

                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Travel_History.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mobile_number", show_mobile_num.getText().toString());

                return parameters;
            }
        };

        HttpsTrustManager.allowAllSSL();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}



