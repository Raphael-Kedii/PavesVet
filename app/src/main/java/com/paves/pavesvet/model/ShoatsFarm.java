package com.paves.pavesvet.model;


public class ShoatsFarm {
    private String shoats_general_info, shoats_breeds, shoats_management, shoats_nutrition,
            shoats_feeding, shoats_housing, shoats_management_prac, shoats_records;

    public ShoatsFarm() {
    }

    public ShoatsFarm(String shoats_general_info, String shoats_breeds, String shoats_management, String shoats_nutrition, String shoats_feeding,
                      String shoats_housing, String shoats_management_prac, String shoats_records) {
        this.shoats_general_info = shoats_general_info;
        this.shoats_breeds = shoats_breeds;
        this.shoats_management = shoats_management;
        this.shoats_nutrition = shoats_nutrition;
        this.shoats_feeding = shoats_feeding;
        this.shoats_housing = shoats_housing;
        this.shoats_management_prac = shoats_management_prac;
        this.shoats_records = shoats_records;
    }

    public String getShoats_general_info() {
        return shoats_general_info;
    }

    public void setShoats_general_info(String shoats_general_info) {
        this.shoats_general_info = shoats_general_info;
    }

    public String getShoats_breeds() {
        return shoats_breeds;
    }

    public void setShoats_breeds(String shoats_breeds) {
        this.shoats_breeds = shoats_breeds;
    }

    public String getShoats_management() {
        return shoats_management;
    }

    public void setShoats_management(String shoats_management) {
        this.shoats_management = shoats_management;
    }

    public String getShoats_nutrition() {
        return shoats_nutrition;
    }

    public void setShoats_nutrition(String shoats_nutrition) {
        this.shoats_nutrition = shoats_nutrition;
    }

    public String getShoats_feeding() {
        return shoats_feeding;
    }

    public void setShoats_feeding(String shoats_feeding) {
        this.shoats_feeding = shoats_feeding;
    }

    public String getShoats_housing() {
        return shoats_housing;
    }

    public void setShoats_housing(String shoats_housing) {
        this.shoats_housing = shoats_housing;
    }

    public String getShoats_management_prac() {
        return shoats_management_prac;
    }

    public void setShoats_management_prac(String shoats_management_prac) {
        this.shoats_management_prac = shoats_management_prac;
    }

    public String getShoats_records() {
        return shoats_records;
    }

    public void setShoats_records(String shoats_records) {
        this.shoats_records = shoats_records;
    }
}
