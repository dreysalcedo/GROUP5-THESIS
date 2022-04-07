package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

import java.util.HashMap;
import java.util.Map;

public class DriverDashboard extends AppCompatActivity implements View.OnClickListener{

    public CardView card1, card2, card3,card4;
    TextView get_driver_user,get_driver_name,get_driver_num;
    RequestQueue queue;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_dashboard);

        //FindID

        card1 = (CardView) findViewById(R.id.cv_driver_profile);
        card2 = (CardView) findViewById(R.id.cv_driver_shortestpath);
        card3 = (CardView) findViewById(R.id.cv_driver_qr);

        get_driver_user = findViewById(R.id.driver_username);
        get_driver_name = findViewById(R.id.driver_name);
        get_driver_num = findViewById(R.id.driver_mobile);

        logout = findViewById(R.id.logout);

        //pass username
        Intent i = getIntent();
        get_driver_user.setText(i.getStringExtra("username"));

        //onClickListener

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

        //logout button

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverDashboard.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        //fetch
        queue= Volley.newRequestQueue(DriverDashboard.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/fetchuser.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobject = new JSONObject(response);
                            JSONArray jsonarray = jsonobject.getJSONArray("users");
                            JSONObject data = jsonarray.getJSONObject(0);
                            String complete_name = data.getString("complete_name");
                            String mobile_num = data.getString("mobile_num");
                            get_driver_name.setText(complete_name);
                            get_driver_num.setText(mobile_num);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(DriverDashboard.this, "Something went wrong", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("username", get_driver_user.getText().toString());

                return parameters;
            }

        };
        queue.add(stringRequest);

    }

    @Override
    public void onClick(View v) {
        //Find Intent
        Intent i;

        switch (v.getId()){
            case R.id.cv_driver_profile:
                i = new Intent(this, Driver_Profile.class);
                i.putExtra("user_name",get_driver_user.getText().toString());
                i.putExtra("mobile_number",get_driver_num.getText().toString());
                i.putExtra("complete_name",get_driver_name.getText().toString());
                startActivity(i);
                break;

            case R.id.cv_driver_shortestpath:
                i = new Intent(this, Driver_ShortestPath.class);
                startActivity(i);
                break;

            case R.id.cv_driver_qr:
                i = new Intent(this, Driver_QR.class);
                startActivity(i);
                break;

        }
    }
}