package com.example.coursework;

import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CountryInformation {                           // содержит информацию о стране

    public ArrayList<CountryPeriod> periods;                 // список с периодами страны

    public CountryInformation(Elements countryPeriods){

        periods = new ArrayList<>();

        countryPeriods.forEach(period->{                   //на каждый период создается свой объект класса Period

            periods.add(new CountryPeriod(period));




        });


    }


}

