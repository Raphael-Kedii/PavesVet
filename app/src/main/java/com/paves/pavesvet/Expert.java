package com.paves.pavesvet;

public class Expert {
    public String full_name, mobile_number,expertise, email_address, kvb_number, location;

    public Expert() {
    }

    public Expert(String full_name, String location, String mobile_number, String expertise, String email_address, String  kvb_number) {
        this.full_name = full_name;
        this.location = location;
        this.mobile_number = mobile_number;
        this.expertise = expertise;
        this.email_address = email_address;
        this.kvb_number = kvb_number;
    }


}
