package com.example.mobileapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;


public class Passenger_Calculator extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    //Declare Variables
    String startpoint, endpoint, type;

    double startLat, startLong, endLat, endLong; //for location marking
    double places_lat1 = 0, places_long1 = 0, places_lat2 = 0, places_long2 = 0; // Google Places Variables
    int flag = 0;
    EditText getInput_startlocation;
    EditText getInput_endpoint;
    Button compute;
    TextView showdestination;
    TextView showdistance;
    TextView showfare;
    Spinner get_passengertype, get_transportation;
    double value;
    String passenger, transportation_mode;
    //get Location Variables
    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize Places
        Places.initialize(getApplicationContext(), "AIzaSyA8HD-E_tnN-c7zzQp4p8mwwlK1HShyBnE");
        setContentView(R.layout.activity_passenger__calculator);


        //getter
        getInput_startlocation = (EditText) findViewById(R.id.txt_initial);
        getInput_endpoint = (EditText) findViewById(R.id.txt_destination);
        showdistance = (TextView) findViewById(R.id.tv_totaldistance);
        showfare = (TextView) findViewById(R.id.tv_totalfare);
        compute = (Button) findViewById(R.id.btn_calc_compute);
        get_passengertype = (Spinner) findViewById(R.id.spinner_passengertype);
        get_transportation = (Spinner) findViewById(R.id.spinner_transpotype);

        //DROPDOWN SPINNER
//create a list of items for the spinner.
        String[] items = new String[]{"Regular", "Discounted"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        get_passengertype.setAdapter(adapter);



        //DROPDOWN SPINNER
//create a list of items for the spinner.
        String[] transportation_modes = new String[]{"Regular Bus", "Air Conditioned Bus", "Jeep", "Taxi" };
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, transportation_modes);
//set the spinners adapter to the previously created one.
        get_transportation.setAdapter(adapter1);



        //set edit text  focusable
        getInput_startlocation.setFocusable(false);
        getInput_startlocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //define type
                type = "starting";
                //Initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY, fields
                ).build(Passenger_Calculator.this);
                //Start Activity Result
                startActivityForResult(intent, 100);
            }
        });
        //Calculate Fare
        compute.setOnClickListener(v -> {
            //Allow all SSL
            HttpsTrustManager.allowAllSSL();
            passenger = get_passengertype.getSelectedItem().toString();
            transportation_mode = get_transportation.getSelectedItem().toString();
            //check if fields are empty
            if (!transportation_mode.equals("") && !passenger.equals("") && !showdistance.equals("")) {
                //if transporation mode = taxi
                if (transportation_mode.equals("Taxi")) {
                    int flagdown = 40;
                    double per_km = 13.50;
                    double traveleddistance = Double.parseDouble(showdistance.getText().toString());
                    double fare_calculation = flagdown + (traveleddistance  * per_km);
                    showfare.setText(Double.toString(fare_calculation));
                }
                //if jeep and passenger = regular
                else if (transportation_mode.equals("Jeep") && passenger.equals("Regular")) {

                    double per_km = 1.5; // succeeding kilometers = adittional PHP 1.50 per km
                    double init_km = 9.0; // first 4 km pay PHP 9.0
                    double traveleddistance  = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 4
                    if(traveleddistance  <= 4){
                        //pay PHP 9 for regular
                        showfare.setText(Double.toString(init_km));
                    }//if traveled distance is more than 4km add the succedding km to the regular fare
                    else {
                        double succeeding_km = traveleddistance - 4;//get succeeding km
                        double fare_calculation = (succeeding_km*per_km)+init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                }  //if jeep and passenger is discounted 20%
                else if (transportation_mode.equals("Jeep") && passenger.equals("Discounted")) {
                    double per_km = 1.2; // succeeding kilometers = adittional PHP 1.20 per km
                    double init_km = 6.20; // first 4 km pay PHP 6.20
                    double traveleddistance  = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 4
                    if(traveleddistance  <= 4){
                        //pay PHP 6.20 for discounted fare
                        showfare.setText(Double.toString(init_km));
                    }//if traveled distance is more than 4km add the succeeding km to the discounted fare
                    else {
                        double succeeding_km = traveleddistance - 4;//get succeeding km
                        double fare_calculation = (succeeding_km*per_km)+init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                }// if aircon bus and passenger is regular
                else if(transportation_mode.equals("Air Conditioned Bus") && passenger.equals("Regular")){
                    double per_km = 1.75; // succeeding kilometers = additional PHP 1.75 per km
                    double init_km = 8.75; // first 5 km pay PHP 9.0
                    double traveleddistance  = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 5
                    if(traveleddistance  <= 5){
                        //pay PHP 9.0 for discounted fare
                        showfare.setText(Double.toString(init_km));

                    }//if traveled distance is more than 5km add the succedding km to the discounted fare
                    else {
                        double succeeding_km = traveleddistance - 5;//get succeeding km
                        double fare_calculation = (succeeding_km*per_km)+init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                } // if air conditioned bus and passenger is discounted 20%
                else if(transportation_mode.equals("Air Conditioned Bus") && passenger.equals("Discounted")) {
                    double per_km = 1.40; // succeeding kilometers = additional PHP 1.40 per km
                    double init_km = 7.00; // first 5 km pay PHP 7.0
                    double traveleddistance = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 5
                    if (traveleddistance <= 5) {
                        //pay PHP 7.20 for discounted fare
                        showfare.setText(Double.toString(init_km));
                    }//if traveled distance is more than 5km add the succeeding km to the discounted fare
                    else {
                        double succeeding_km = traveleddistance - 5;//get succeeding km
                        double fare_calculation = (succeeding_km * per_km) + init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                }                // if regular bus and passenger is regular
                else if(transportation_mode.equals("Regular Bus") && passenger.equals("Regular")){
                    double per_km = 1.55; // succeeding kilometers = additional PHP 1.55 per km
                    double init_km = 9.0; // first 5 km pay PHP 9.0
                    double traveleddistance  = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 5
                    if(traveleddistance  <= 5){
                        //pay PHP 9.0 for discounted fare
                        showfare.setText(Double.toString(init_km));
                    }//if traveled distance is more than 5km add the succedding km to the discounted fare
                    else {
                        double succeeding_km = traveleddistance - 5;//get succeeding km
                        double fare_calculation = (succeeding_km*per_km)+init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                } // if regular bus and passenger is discounted 20%
                else if(transportation_mode.equals("Regular Bus") && passenger.equals("Discounted")) {
                    double per_km = 1.24; // succeeding kilometers = additional PHP 1.24 per km
                    double init_km = 7.20; // first 5 km pay PHP 7.20
                    double traveleddistance = Double.parseDouble(showdistance.getText().toString());
                    //if distance is less than or equals 5
                    if (traveleddistance <= 5) {
                        //pay PHP 7.20 for discounted fare
                        showfare.setText(Double.toString(init_km));
                    }//if traveled distance is more than 5km add the succeeding km to the discounted fare
                    else {
                        double succeeding_km = traveleddistance - 5;//get succeeding km
                        double fare_calculation = (succeeding_km * per_km) + init_km;//total fare
                        showfare.setText(Double.toString(fare_calculation));
                    }
                }
            }else{
                Toast.makeText(getApplicationContext(), "All fields are  required", Toast.LENGTH_SHORT).show();
            }//end
        });
        // sets edit text non-focusable
        getInput_endpoint.setFocusable(false);
        getInput_endpoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //define type
                type = "destination";
                //Initialize place field list
                List<Place.Field> fields = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG);
                //Create intent
                Intent intent = new Autocomplete.IntentBuilder(
                        AutocompleteActivityMode.OVERLAY, fields
                ).build(Passenger_Calculator.this);
                //Start Activity Result
                startActivityForResult(intent, 100);
                //Set default text on text view showdistance

            }
        });



    }//end of oncreate
    //spinner method

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
    //methods

    private class DestinationGeoCoderHandler extends Handler {

        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            showdestination.setText(locationAddress);
        }

    }
    private class StartGeoCoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            showdestination.setText(locationAddress);
        }

    }

    //Google Directions API
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, requestCode, data);
        //Check condition
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //if success
            //initializes place
            Place place = Autocomplete.getPlaceFromIntent(data);

            //check condition
            if (type.equals("starting")) {
                //when type is source
                //increase flag value
                flag++;
                //set address on edit text
                getInput_startlocation.setText(place.getAddress());
                String sSource = String.valueOf(place.getLatLng());
                sSource = sSource.replaceAll("lat/lng: ", "");
                sSource = sSource.replace("(", "");
                sSource = sSource.replace(")", "");
                String[] split = sSource.split(",");
                places_lat1 = Double.parseDouble(split[0]);
                places_long1 = Double.parseDouble(split[1]);
            } else {
                //when type is destination
                //increase flag
                flag++;
                //set address on edit text
                getInput_endpoint.setText(place.getAddress());
                String sDestination = String.valueOf(place.getLatLng());
                sDestination = sDestination.replaceAll("lat/lng: ", "");
                sDestination = sDestination.replace("(", "");
                sDestination = sDestination.replace(")", "");
                String[] split = sDestination.split(",");
                places_lat2 = Double.parseDouble(split[0]);
                places_long2 = Double.parseDouble(split[1]);
            }
            //check condition
            if (flag >= 2) {
                //when flag is greater than and equal to 2
                //Calculate distance
                showdistance.setText(Double.toString(haversine(places_lat1, places_long1, places_lat2, places_long2)));
            } else if (requestCode == AutocompleteActivity.RESULT_ERROR) {
                //when error
                //initialize status
                Status status = Autocomplete.getStatusFromIntent(data);
                Toast.makeText(getApplicationContext(), status.getStatusMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    //Haversine Algorithm

    public static double haversine(double startLat, double startLong, double endLat, double endLong) {
        //distance between latitudes and longitudes
        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));
        //convert to radians
        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);
        //apply formula
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLong / 2), 2) * Math.cos(startLat) * Math.cos(endLat);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }//end code haversine
}

