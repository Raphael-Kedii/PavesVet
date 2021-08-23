package com.paves.pavesvet.model;

public class Aqua {
    private String aqua_general_info, aqua_species,aqua_management, polyculture, aqua_market, aqua_crocodile;

    public Aqua() {
    }

    public Aqua(String aqua_general_info, String aqua_species, String aqua_management,
                String polyculture, String aqua_market, String aqua_crocodile) {
        this.aqua_general_info = aqua_general_info;
        this.aqua_species = aqua_species;
        this.aqua_management = aqua_management;
        this.polyculture = polyculture;
        this.aqua_market = aqua_market;
        this.aqua_crocodile = aqua_crocodile;
    }

    public String getAqua_general_info() {
        return aqua_general_info;
    }

    public void setAqua_general_info(String aqua_general_info) {
        this.aqua_general_info = aqua_general_info;
    }

    public String getAqua_species() {
        return aqua_species;
    }

    public void setAqua_species(String aqua_species) {
        this.aqua_species = aqua_species;
    }

    public String getAqua_management() {
        return aqua_management;
    }

    public void setAqua_management(String aqua_management) {
        this.aqua_management = aqua_management;
    }

    public String getPolyculture() {
        return polyculture;
    }

    public void setPolyculture(String polyculture) {
        this.polyculture = polyculture;
    }

    public String getAqua_market() {
        return aqua_market;
    }

    public void setAqua_market(String aqua_market) {
        this.aqua_market = aqua_market;
    }

    public String getAqua_crocodile() {
        return aqua_crocodile;
    }

    public void setAqua_crocodile(String aqua_crocodile) {
        this.aqua_crocodile = aqua_crocodile;
    }
}
