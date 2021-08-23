package com.paves.pavesvet.model;

public class PoultryFarm {
    private String poultry_general_info, poultry_breeds, poultry_management, poultry_hatchery;

    public PoultryFarm() {
    }

    public PoultryFarm(String poultry_general_info, String poultry_breeds,
                       String poultry_management, String poultry_hatchery) {
        this.poultry_general_info = poultry_general_info;
        this.poultry_breeds = poultry_breeds;
        this.poultry_management = poultry_management;
        this.poultry_hatchery = poultry_hatchery;
    }

    public String getPoultry_general_info() {
        return poultry_general_info;
    }

    public void setPoultry_general_info(String poultry_general_info) {
        this.poultry_general_info = poultry_general_info;
    }

    public String getPoultry_breeds() {
        return poultry_breeds;
    }

    public void setPoultry_breeds(String poultry_breeds) {
        this.poultry_breeds = poultry_breeds;
    }

    public String getPoultry_management() {
        return poultry_management;
    }

    public void setPoultry_management(String poultry_management) {
        this.poultry_management = poultry_management;
    }

    public String getPoultry_hatchery() {
        return poultry_hatchery;
    }

    public void setPoultry_hatchery(String poultry_hatchery) {
        this.poultry_hatchery = poultry_hatchery;
    }
}
