package com.example.mobileapp;

public class TravelData {

    private String transaction_id, fare, mobile_number, initial_location, destination, status, distance;

    public TravelData() {
    }

    public TravelData(String transaction_id, String fare, String mobile_number, String initial_location, String destination, String status, String distance) {
        this.transaction_id = transaction_id;
        this.fare = fare;
        this.mobile_number = mobile_number;
        this.initial_location = initial_location;
        this.destination = destination;
        this.status = status;
        this.distance = distance;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getInitial_location() {
        return initial_location;
    }

    public void setInitial_location(String initial_location) {
        this.initial_location = initial_location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}