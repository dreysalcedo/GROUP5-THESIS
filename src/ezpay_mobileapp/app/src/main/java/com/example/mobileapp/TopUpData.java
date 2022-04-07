package com.example.mobileapp;

public class TopUpData {
    private String transaction_id,mobile_num,value,date,cashier,terminal_name;

    public TopUpData() {
    }

    public TopUpData(String transaction_id, String mobile_num, String value, String date, String cashier, String terminal_name) {
        this.transaction_id = transaction_id;
        this.mobile_num = mobile_num;
        this.value = value;
        this.date = date;
        this.cashier = cashier;
        this.terminal_name = terminal_name;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getTerminal_name() {
        return terminal_name;
    }

    public void setTerminal_name(String terminal_name) {
        this.terminal_name = terminal_name;
    }
}
