package com.paves.pavesvet.model;

public class PigsFarm {
    private String pig_general_info, pig_breeds, pig_breeding, pig_feeding, pig_pens, pig_management;

    public PigsFarm() {
    }

    public PigsFarm(String pig_general_info, String pig_breeds, String pig_breeding,
                    String pig_feeding, String pig_pens, String pig_management) {
        this.pig_general_info = pig_general_info;
        this.pig_breeds = pig_breeds;
        this.pig_breeding = pig_breeding;
        this.pig_feeding = pig_feeding;
        this.pig_pens = pig_pens;
        this.pig_management = pig_management;
    }

    public String getPig_general_info() {
        return pig_general_info;
    }

    public void setPig_general_info(String pig_general_info) {
        this.pig_general_info = pig_general_info;
    }

    public String getPig_breeds() {
        return pig_breeds;
    }

    public void setPig_breeds(String pig_breeds) {
        this.pig_breeds = pig_breeds;
    }

    public String getPig_breeding() {
        return pig_breeding;
    }

    public void setPig_breeding(String pig_breeding) {
        this.pig_breeding = pig_breeding;
    }

    public String getPig_feeding() {
        return pig_feeding;
    }

    public void setPig_feeding(String pig_feeding) {
        this.pig_feeding = pig_feeding;
    }

    public String getPig_pens() {
        return pig_pens;
    }

    public void setPig_pens(String pig_pens) {
        this.pig_pens = pig_pens;
    }

    public String getPig_management() {
        return pig_management;
    }

    public void setPig_management(String pig_management) {
        this.pig_management = pig_management;
    }
}
