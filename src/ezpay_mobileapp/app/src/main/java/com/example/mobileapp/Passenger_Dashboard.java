package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

public class Passenger_Dashboard extends AppCompatActivity implements View.OnClickListener {

    public CardView card1, card2, card3,card4;
    TextView getTv_signup_name, getTv_signup_mobilenum,getTv_signup_balance,getTvusername;
    String st;
    RequestQueue queue;
    TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passenger_dashboard);

        //FindID

        card1 = (CardView) findViewById(R.id.cv_profile);
        card2 = (CardView) findViewById(R.id.cv_shortestpath);
        card3 = (CardView) findViewById(R.id.cv_qr);

        getTv_signup_name = findViewById(R.id.tv_passenger_name);
        getTv_signup_mobilenum = findViewById(R.id.tv_passenger_mobilenum);
        getTv_signup_balance = findViewById(R.id.tv_passenger_balance);
        getTvusername = findViewById(R.id.tv_passenger_username);

        logout = findViewById(R.id.logout);

        //pass username
        Intent i = getIntent();
        getTvusername.setText(i.getStringExtra("username"));

        //onClickListener
        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);


        //logout button

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Passenger_Dashboard.this, Login_Activity.class);
                startActivity(intent);
                finish();
            }
        });

        //fetch
        queue= Volley.newRequestQueue(Passenger_Dashboard.this);
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
                            String balance = data.getString("balance");
                            Double parseBalance = Double.parseDouble(balance);
                            DecimalFormat df = new DecimalFormat(("#.##"));
                            parseBalance = Double.valueOf(df.format(parseBalance));
                            getTv_signup_name.setText(complete_name);
                            getTv_signup_mobilenum.setText(mobile_num);
                            getTv_signup_balance.setText(parseBalance.toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Passenger_Dashboard.this, "Something went wrong", Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("username", getTvusername.getText().toString());

                return parameters;
            }

        };
        queue.add(stringRequest);
        //end of fetch

    }//end of oncreate

    @Override
    public void onClick(View v) {
        //Find Intent
        Intent i ;
        
        switch (v.getId()){
            case R.id.cv_profile:
                i = new Intent(this, Passenger_Profile.class);
                i.putExtra("user_name",getTvusername.getText().toString());
                i.putExtra("mobile_number",getTv_signup_mobilenum.getText().toString());
                i.putExtra("balance",getTv_signup_balance.getText().toString());
                i.putExtra("complete_name",getTv_signup_name.getText().toString());

                startActivity(i);
                break;

            case R.id.cv_shortestpath:
                i = new Intent(this, Passenger_ShortestPath.class);
                startActivity(i);
                break;

            case R.id.cv_qr:
                i = new Intent(this, Passenger_QR.class);
                i.putExtra ( "mobile_number", getTv_signup_mobilenum.getText().toString());
                startActivity(i);
                break;

        }

    }
}