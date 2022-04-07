package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;


import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class SignUp_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //Initialize
    Button Signup;
    EditText get_name;
    EditText get_username;
    EditText get_password;
    EditText get_mobilenumber;
    CheckBox signup_showpass;
    Spinner get_usertype;
    ProgressBar progressBar;
    private String name;
    private String username;
    private String password;
    private String mobile_num;
    private String user_type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_);
        //Find ID
        Signup = findViewById(R.id.btn_signup);
        get_name = findViewById(R.id.txtfield_signup_name);
        get_username = findViewById(R.id.txtfield_signup_username);
        get_password = findViewById(R.id.txtfield_signup_pass);
        get_mobilenumber= findViewById(R.id.txtfield_signup_mobilenum);
        signup_showpass = findViewById(R.id.signup_showpass);
        //progressBar = findViewById(R.id.progressBar);
        //get the spinner from the xml.
        get_usertype = findViewById(R.id.signup_usertype);

        //showPassword
        signup_showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    get_password.setTransformationMethod(null);
                }
                else {
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
        get_usertype.setAdapter(adapter);
        get_usertype.setOnItemSelectedListener(this);





        //Signup Button
        Signup.setOnClickListener(v -> {
            //Allow all SSL
            HttpsTrustManager.allowAllSSL();
            //Get Text
            name = get_name.getText().toString();
            username = get_username .getText().toString();
            password= get_password.getText().toString();
            mobile_num= get_mobilenumber.getText().toString();
            user_type = get_usertype.getSelectedItem().toString();
            String balance = "0";
            if(!name.equals("") && !username.equals("") && !password.equals("") && !mobile_num.equals("") && !user_type.equals("") ) {
                //progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(() -> {
                    //Starting Write and Read topUpData with URL
                    //Creating array for parameters
                    String[] field = new String[6];
                    field[0] = "complete_name";
                    field[1] = "username";
                    field[2] = "password";
                    field[3] = "mobile_num";
                    field[4] = "user_type";
                    field[5] = "balance";

                    //Creating array for topUpData
                    String[] data = new String[6];
                    data[0] = name;
                    data[1] = username;
                    data[2] = password;
                    data[3] = mobile_num;
                    data[4] = user_type;
                    data[5] = balance;

                    PutData putData = new PutData("https://sdffea.com/Thesis/signup.php", "POST", field, data);
                    if (putData.startPut()) {
                        if (putData.onComplete()) {
                            //tiprogressBar.setVisibility(View.GONE);
                            String result = putData.getResult();
                            //check if what register.php throws
                            if(result.equals("Sign Up Success")){
                                Intent intent = new Intent(SignUp_Activity.this, Login_Activity.class);
                                startActivity(intent);
                                finish();;
                            }else{
                                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    //End Write and Read topUpData with URL
                });

            }//end of if strings are empty condition
            else{
                Toast.makeText(getApplicationContext(), "All fields are  required", Toast.LENGTH_SHORT).show();

            }
        });

    }//End of onCreate()

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}