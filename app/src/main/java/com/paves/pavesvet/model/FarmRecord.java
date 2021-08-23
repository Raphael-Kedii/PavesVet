package com.paves.pavesvet.model;

public class FarmRecord {
    private String livestock_income, crop_income, other_income, total_income, livestock_expense, crop_expense, other_espense, total_expense;

    public FarmRecord() {
    }

    public FarmRecord(String livestock_income, String crop_income, String other_income, String total_income,
                      String livestock_expense, String crop_expense, String other_espense, String total_expense) {
        this.livestock_income = livestock_income;
        this.crop_income = crop_income;
        this.other_income = other_income;
        this.total_income = total_income;
        this.livestock_expense = livestock_expense;
        this.crop_expense = crop_expense;
        this.other_espense = other_espense;
        this.total_expense = total_expense;
    }

    public String getLivestock_income() {
        return livestock_income;
    }

    public void setLivestock_income(String livestock_income) {
        this.livestock_income = livestock_income;
    }

    public String getCrop_income() {
        return crop_income;
    }

    public void setCrop_income(String crop_income) {
        this.crop_income = crop_income;
    }

    public String getOther_income() {
        return other_income;
    }

    public void setOther_income(String other_income) {
        this.other_income = other_income;
    }

    public String getTotal_income() {
        return total_income;
    }

    public void setTotal_income(String total_income) {
        this.total_income = total_income;
    }

    public String getLivestock_expense() {
        return livestock_expense;
    }

    public void setLivestock_expense(String livestock_expense) {
        this.livestock_expense = livestock_expense;
    }

    public String getCrop_expense() {
        return crop_expense;
    }

    public void setCrop_expense(String crop_expense) {
        this.crop_expense = crop_expense;
    }

    public String getOther_espense() {
        return other_espense;
    }

    public void setOther_espense(String other_espense) {
        this.other_espense = other_espense;
    }

    public String getTotal_expense() {
        return total_expense;
    }

    public void setTotal_expense(String total_expense) {
        this.total_expense = total_expense;
    }
}
