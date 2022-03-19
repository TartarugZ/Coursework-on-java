package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Coin {

    private  String country;
    private  String currency;
    private  String value;
    private  String category;
    private Optional<Float> cost;
    private String linkUcoin;
    private LocalDate dataOfCreate;

    public Optional<Float> getCost() {
        return cost;
    }

    public LocalDate getDataOfCreate() {
        return dataOfCreate;
    }

    public Coin(String country, String currency, String value, String category, Optional<Float> cost, String linkUcoin) {

        this.country = country;
        this.currency = currency;
        this.value = value;
        this.category = category;
        this.cost = cost;
        this.linkUcoin = linkUcoin;
        this.dataOfCreate =dataOfCreate.now() ;

    }

    public String getCountry() {
        return country;
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


}
