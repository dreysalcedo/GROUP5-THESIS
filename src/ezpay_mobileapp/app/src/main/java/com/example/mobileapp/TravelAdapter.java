package com.example.mobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TravelAdapter extends ArrayAdapter<TravelData> {

        Context context;
        List<TravelData> arrayListTravelData;


        public TravelAdapter(@NonNull Context context, List<TravelData> arrayListTravelData) {
                super(context, R.layout.travel_history_list_item,arrayListTravelData);

                this.context = context;
                this.arrayListTravelData = arrayListTravelData;
         }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.travel_history_list_item,null, true);

                TextView travelId = view1.findViewById(R.id.travel_id);
                TextView travelFare = view1.findViewById(R.id.travel_fare);
                TextView travelMobileNum = view1.findViewById(R.id.travel_mobilenum);
                TextView travelInitLoc = view1.findViewById(R.id.travel_initlocation);
                TextView travelDestination = view1.findViewById(R.id.travel_destination);
                TextView travelStatus = view1.findViewById(R.id.travel_status);
                TextView travelDistance = view1.findViewById(R.id.travel_distance);

                //set
                travelId.setText(arrayListTravelData.get(position).getTransaction_id());
                travelFare.setText(arrayListTravelData.get(position).getFare());
                travelMobileNum.setText(arrayListTravelData.get(position).getMobile_number());
                travelInitLoc.setText(arrayListTravelData.get(position).getInitial_location());
                travelDestination.setText(arrayListTravelData.get(position).getDestination());
                travelStatus.setText(arrayListTravelData.get(position).getStatus());
                travelDistance.setText(arrayListTravelData.get(position).getDistance());

                return view1;
        }
}




