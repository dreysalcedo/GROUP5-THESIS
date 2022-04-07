package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Initialize variables
    Button Login;
    TextView Signup, sqluser_type;
    EditText get_username, get_password;
    Spinner get_user_type;
    private String username, password,user_type;
    private String login_spinner;
    CheckBox showpass;
    RequestQueue queue;
    //ProgressBar progressBar_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //Find ID
        Login = findViewById(R.id.btn_login);
        Signup = findViewById(R.id.textview_signup);
        get_username = findViewById(R.id.login_username);
        get_password = findViewById(R.id.login_password);
        get_user_type = findViewById(R.id.login_usertype);
        showpass = findViewById(R.id.login_showpass);
        sqluser_type = findViewById(R.id.view_user);

        //wrap edit text to textwatcher
        get_username.addTextChangedListener(loginTextWatcher);
        get_password.addTextChangedListener(loginTextWatcher);

        //progressBar_login = findViewById(R.id.progressBar_login);
        //Signup
        Signup.setOnClickListener(v -> {
            Intent intent = new Intent(Login_Activity.this, SignUp_Activity.class);
            startActivity(intent);
            finish();
            Toast.makeText(getApplicationContext(), "Register Here", Toast.LENGTH_SHORT).show();
        });


        //showPassword

        showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    get_password.setTransformationMethod(null);
                } else {
                    get_password.setTransformationMethod(new PasswordTransformationMethod());
                }
            }
        });

        //dropdown function
       ArrayAdapter adapter = ArrayAdapter.createFromResource(
               this,
               R.array.login_users,
               R.layout.color_spinner_layout
       );
       adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        get_user_type.setAdapter(adapter);
        get_user_type.setOnItemSelectedListener(this);



        //Log in Button
        Login.setOnClickListener(v -> {
            //Allow all SSL
            HttpsTrustManager.allowAllSSL();
            //Get Text
            username = get_username.getText().toString();
            password = get_password.getText().toString();
            user_type = get_user_type.getSelectedItem().toString();
            if (!username.equals("") && !password.equals("") && !user_type.equals("")){
                //progressBar_login.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {
                    //Starting Write and Read topUpData with URL
                    //Creating array for parameters
                    String[] field = new String[3];

                    field[0] = "username";
                    field[1] = "password";
                    field[2] = "user_type";

                    //Creating array for topUpData
                    String[] data = new String[3];
                    data[0] = username;
                    data[1] = password;
                    data[2] = user_type;

                    PutData putData = new PutData("https://sdffea.com/Thesis/login.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            //progressBar_login.setVisibility(View.GONE);
                            String result = putData.getResult();
                            //check if what login.php throws
                            if (result.equals("Login Success")) {
                                if(user_type.equals("Passenger")){
                                    Intent topassenger = new Intent(Login_Activity.this, Passenger_Dashboard.class);
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    topassenger.putExtra("username", get_username.getText().toString());
                                    startActivity(topassenger );
                                    finish();
                                }else if(user_type.equals("Driver")){
                                    Intent todriver = new Intent(Login_Activity.this, DriverDashboard.class);
                                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                                    todriver.putExtra("username", get_username.getText().toString());
                                    startActivity(todriver);
                                    finish();
                                }else{
                                    Toast.makeText(getApplicationContext(), "Error on User_Type", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    //End Write and Read topUpData with URL
                });

            }//end of if strings are empty condition
            else {
                Toast.makeText(getApplicationContext(), "All fields are  required", Toast.LENGTH_SHORT).show();
            }

        });
        //Sign up TextView

    }// end of onCreate
    //textwatcher
    TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                String usernameInput =  get_username.getText().toString().trim();
                String passwordInput =  get_password.getText().toString().trim();
                Login.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());
          /*  //fetch  account user type
            queue= Volley.newRequestQueue(Login_Activity.this);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://sdffea.com/Thesis/fetchuser.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonobject = new JSONObject(response);
                                JSONArray jsonarray = jsonobject.getJSONArray("users");
                                JSONObject data = jsonarray.getJSONObject(0);
                                String sql_user_type = data.getString("user_type");
                                sqluser_type.setText(sql_user_type);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("username",   username);

                    return parameters;
                }

            };
            queue.add(stringRequest);
            //end of fetch

           */
        }

        @Override
        public void afterTextChanged(Editable s) {


        }
    };
    //spinner method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }
    }