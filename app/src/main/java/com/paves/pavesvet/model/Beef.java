package com.paves.pavesvet.model;

public class Beef {
    private String beef_general_info, beef_breeds, beef_management, beef_management_act, beef_records, beef_nutrient;

    public Beef() {
    }

    public Beef(String beef_general_info, String beef_breeds, String beef_management,
                String beef_management_act, String beef_records, String beef_nutrient) {
        this.beef_general_info = beef_general_info;
        this.beef_breeds = beef_breeds;
        this.beef_management = beef_management;
        this.beef_management_act = beef_management_act;
        this.beef_records = beef_records;
        this.beef_nutrient = beef_nutrient;
    }

    public String getBeef_general_info() {
        return beef_general_info;
    }

    public void setBeef_general_info(String beef_general_info) {
        this.beef_general_info = beef_general_info;
    }

    public String getBeef_breeds() {
        return beef_breeds;
    }

    public void setBeef_breeds(String beef_breeds) {
        this.beef_breeds = beef_breeds;
    }

    public String getBeef_management() {
        return beef_management;
    }

    public void setBeef_management(String beef_management) {
        this.beef_management = beef_management;
    }

    public String getBeef_management_act() {
        return beef_management_act;
    }

    public void setBeef_management_act(String beef_management_act) {
        this.beef_management_act = beef_management_act;
    }

    public String getBeef_records() {
        return beef_records;
    }

    public void setBeef_records(String beef_records) {
        this.beef_records = beef_records;
    }

    public String getBeef_nutrient() {
        return beef_nutrient;
    }

    public void setBeef_nutrient(String beef_nutrient) {
        this.beef_nutrient = beef_nutrient;
    }
}
