package com.paves.pavesvet;

public class ModelV {

    private String full_name, mobile_number, kvb_number, email_address,expertise, location;

    public ModelV() {
    }

    public ModelV(String full_name, String mobile_number, String kvb_number, String email_address, String expertise, String location) {
        this.full_name = full_name;
        this.mobile_number = mobile_number;
        this.kvb_number = kvb_number;
        this.email_address = email_address;
        this.expertise = expertise;
        this.location = location;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setName(String name) {
        this.full_name = name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
    public String getKvb_number() {
        return kvb_number;
    }

    public void setKvb_number(String kvb_number) {
        this.kvb_number = kvb_number;
    }
    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}



