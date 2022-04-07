package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class TopUp_Transaction extends AppCompatActivity {
    ListView listView;
    TextView show_mobileNum;
    TopUpAdapter adapter;
    public static ArrayList<TopUpData> topUpDataArrayList = new ArrayList<>();
    String url = "http://sdffea.com/Thesis/topuptransaction.php";

    TopUpData topUpData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_transaction);
        //find id
        show_mobileNum = findViewById(R.id.topup_showmobile_num);
        listView = findViewById(R.id.myListView);
        adapter = new TopUpAdapter(this, topUpDataArrayList);
        listView.setAdapter(adapter);

        //pass  mobile_num
        Intent i = getIntent();
        show_mobileNum.setText(i.getStringExtra("mobile_number"));

        retrieveData();
    }

    public void retrieveData() {

        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        topUpDataArrayList.clear();
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("Success");
                            JSONArray jsonArray = jsonObject.getJSONArray("transactiondb");

                            if (success.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("transaction_id");
                                    String mobile_num = object.getString("mobile_num");
                                    String value = object.getString("value");
                                    String date = object.getString("date");
                                    String cashier = object.getString("cashier");
                                    String terminal_name = object.getString("terminal_name");

                                    topUpData = new TopUpData(id,mobile_num,value,date,cashier,terminal_name);

                                    topUpDataArrayList.add(topUpData);
                                    adapter.notifyDataSetChanged();


                                }




                            }




                        }
                        catch (JSONException e ){
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TopUp_Transaction.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("mobile_num", show_mobileNum.getText().toString());

                return parameters;
            }
        };

        HttpsTrustManager.allowAllSSL();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
