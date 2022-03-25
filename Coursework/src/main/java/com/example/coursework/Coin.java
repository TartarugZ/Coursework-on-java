package com.example.coursework;

import java.time.LocalDate;
import java.util.Optional;

public class Coin {

    private String country;
    private int years;
   /* private  String currency;
    private  String value;
    private  String category;
    private Optional<Float> cost;
    private String linkUcoin;
    private LocalDate dataOfCreate;*/

    public Coin(String country, int years) {

        this.country = country;
        this.years = years;
        /*this.currency = currency;
       this.value = value;
        this.category = category;
        this.cost = cost;
        this.linkUcoin = linkUcoin;
        this.dataOfCreate =dataOfCreate.now() ;*/

    }

    public String getCountry() {
        return country;
    }
    public String getYears(){
        return String.valueOf(this.years);}
/*
public Optional<Float> getCost() {
        return cost;
    }

    public LocalDate getDataOfCreate() {
        return dataOfCreate;
    }
    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public Optional<Float> getCostActual() {
        return cost;
    }


    public String getLinkUcoin() {
        return linkUcoin;
    }
*/

}
