package com.paves.pavesvet.model;

public class Rabittfish {

    private String disease_title, aetiological_agent, transmission,
            clinical_signs, differential_diagnosis, treatment_and_control;

    public Rabittfish() {
    }

    public Rabittfish(String disease_title, String aetiological_agent, String transmission, String clinical_signs,
                      String differential_diagnosis, String treatment_and_control) {
        this.disease_title = disease_title;
        this.aetiological_agent = aetiological_agent;
        this.transmission = transmission;
        this.clinical_signs = clinical_signs;
        this.differential_diagnosis = differential_diagnosis;
        this.treatment_and_control = treatment_and_control;
    }

    public String getDisease_title() {
        return disease_title;
    }

    public void setDisease_title(String disease_title) {
        this.disease_title = disease_title;
    }

    public String getAetiological_agent() {
        return aetiological_agent;
    }

    public void setAetiological_agent(String aetiological_agent) {
        this.aetiological_agent = aetiological_agent;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getClinical_signs() {
        return clinical_signs;
    }

    public void setClinical_signs(String clinical_signs) {
        this.clinical_signs = clinical_signs;
    }

    public String getDifferential_diagnosis() {
        return differential_diagnosis;
    }

    public void setDifferential_diagnosis(String differential_diagnosis) {
        this.differential_diagnosis = differential_diagnosis;
    }

    public String getTreatment_and_control() {
        return treatment_and_control;
    }

    public void setTreatment_and_control(String treatment_and_control) {
        this.treatment_and_control = treatment_and_control;
    }
}
