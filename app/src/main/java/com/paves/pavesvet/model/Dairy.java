package com.paves.pavesvet.model;

public class Dairy {
    private String general_info, breeds, calf_fm, calf_hs, calf_m, heifers, dairy_feed, dairy_m,
    routine, records, dairy_hs;

    public Dairy() {
    }

    public Dairy(String general_info, String breeds, String calf_fm, String calf_hs, String calf_m, String heifers,
                 String dairy_feed, String dairy_m, String routine, String records, String dairy_hs) {
        this.general_info = general_info;
        this.breeds = breeds;
        this.calf_fm = calf_fm;
        this.calf_hs = calf_hs;
        this.calf_m = calf_m;
        this.heifers = heifers;
        this.dairy_feed = dairy_feed;
        this.dairy_m = dairy_m;
        this.routine = routine;
        this.records = records;
        this.dairy_hs = dairy_hs;
    }

    public String getGeneral_info() {
        return general_info;
    }

    public void setGeneral_info(String general_info) {
        this.general_info = general_info;
    }

    public String getBreeds() {
        return breeds;
    }

    public void setBreeds(String breeds) {
        this.breeds = breeds;
    }

    public String getCalf_fm() {
        return calf_fm;
    }

    public void setCalf_fm(String calf_fm) {
        this.calf_fm = calf_fm;
    }

    public String getCalf_hs() {
        return calf_hs;
    }

    public void setCalf_hs(String calf_hs) {
        this.calf_hs = calf_hs;
    }

    public String getCalf_m() {
        return calf_m;
    }

    public void setCalf_m(String calf_m) {
        this.calf_m = calf_m;
    }

    public String getHeifers() {
        return heifers;
    }

    public void setHeifers(String heifers) {
        this.heifers = heifers;
    }

    public String getDairy_feed() {
        return dairy_feed;
    }

    public void setDairy_feed(String dairy_feed) {
        this.dairy_feed = dairy_feed;
    }

    public String getDairy_m() {
        return dairy_m;
    }

    public void setDairy_m(String dairy_m) {
        this.dairy_m = dairy_m;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String routine) {
        this.routine = routine;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public String getDairy_hs() {
        return dairy_hs;
    }

    public void setDairy_hs(String dairy_hs) {
        this.dairy_hs = dairy_hs;
    }
}
