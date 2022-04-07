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

public class TopUpAdapter extends ArrayAdapter <TopUpData> {

    Context context;
    List<TopUpData> arrayListData;


    public TopUpAdapter(@NonNull Context context, List<TopUpData> arrayListData) {
        super(context, R.layout.topup_transaction_list_item,arrayListData);

        this.context = context;
        this.arrayListData = arrayListData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topup_transaction_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvNumber = view.findViewById(R.id.txt_number);
        TextView tvValue = view.findViewById(R.id.txt_value);
        TextView tvDate = view.findViewById(R.id.txt_date);
        TextView tvCashier = view.findViewById(R.id.txt_cashier);
        TextView tvTerminalName = view.findViewById(R.id.txt_terminal_name);


        tvID.setText(arrayListData.get(position).getTransaction_id());
        tvNumber.setText(arrayListData.get(position).getMobile_num());
        tvValue.setText(arrayListData.get(position).getValue());
        tvDate.setText(arrayListData.get(position).getDate());
        tvCashier.setText(arrayListData.get(position).getCashier());
        tvTerminalName.setText(arrayListData.get(position).getTerminal_name());

        return view;
    }
}
