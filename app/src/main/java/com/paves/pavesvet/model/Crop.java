package com.paves.pavesvet.model;

public class Crop {
    private String crop_name, crop_nameInfo;

    public Crop() {
    }

    public Crop(String crop_name, String crop_nameInfo) {
        this.crop_name = crop_name;
        this.crop_nameInfo = crop_nameInfo;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getCrop_nameInfo() {
        return crop_nameInfo;
    }

    public void setCrop_nameInfo(String crop_nameInfo) {
        this.crop_nameInfo = crop_nameInfo;
    }
}
