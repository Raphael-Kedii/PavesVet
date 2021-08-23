package com.paves.pavesvet.model;

public class MarketUpdate {
    private String market_title, cow, bull,
            doe, billy, ewe, ram, cock, hen;

    public MarketUpdate() {
    }

    public MarketUpdate(String market_title, String cow, String bull,
                        String doe, String billy, String ewe, String ram, String cock, String hen) {
        this.market_title = market_title;
        this.cow = cow;
        this.bull = bull;
        this.doe = doe;
        this.billy = billy;
        this.ewe = ewe;
        this.ram = ram;
        this.cock = cock;
        this.hen = hen;
    }

    public String getMarket_title() {
        return market_title;
    }

    public void setMarket_title(String market_title) {
        this.market_title = market_title;
    }

    public String getCow() {
        return cow;
    }

    public void setCow(String cow) {
        this.cow = cow;
    }

    public String getBull() {
        return bull;
    }

    public void setBull(String bull) {
        this.bull = bull;
    }

    public String getDoe() {
        return doe;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }

    public String getBilly() {
        return billy;
    }

    public void setBilly(String billy) {
        this.billy = billy;
    }

    public String getEwe() {
        return ewe;
    }

    public void setEwe(String ewe) {
        this.ewe = ewe;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCock() {
        return cock;
    }

    public void setCock(String cock) {
        this.cock = cock;
    }

    public String getHen() {
        return hen;
    }

    public void setHen(String hen) {
        this.hen = hen;
    }
}
