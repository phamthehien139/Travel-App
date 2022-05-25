package com.example.travel.Models;

public class CountryItem {

    private int imageResourse;
    private String title;
    private String key_id;
    private String favStatus;
    private String countrydesc;
    private String currency;
    private String language;
    private String capital;
    private String other;

    //constructor
    public CountryItem() {
    }

    public CountryItem(int imageResourse, String title, String key_id, String favStatus, String countrydesc, String currency, String language, String capital, String other) {
        this.imageResourse = imageResourse;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.countrydesc =countrydesc;
        this.currency =currency;
        this.language=language;
        this.capital=capital;
        this.other=other;
    }

    public int getImageResourse() {
        return imageResourse;
    }

    public void setImageResourse(int imageResourse) {
        this.imageResourse = imageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public String getCountrydesc() {
        return countrydesc;
    }

    public void setCountrydesc(String countrydesc) {
        this.countrydesc = countrydesc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
