package com.example.coursework;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class CoinSearcher {
    public static ArrayList<Coin> CC=new ArrayList<>();

    private Document doc;
    private Elements countries; //список со всеми странами


    public CoinSearcher() throws IOException {  //отвечает за подгрузку нужной инфы дляотпимизации поиска
        getCountries();

    }

    public void getCountries() throws IOException {

        doc = Jsoup.connect("https://en.ucoin.net/catalog").get();
        countries = doc.getElementsByAttributeValue("class","left wrap nopad");
        if(countries==null){System.out.println("Error parse countries"); };
        testCountries(countries);
    }

    public static void smartCountrySelection(String country){
    }


    public void testCountries(Elements countries) {

        System.out.println(countries.size());

        countries.forEach(scope->{
            String r=scope.text();
            CC.add(new Coin(r, ThreadLocalRandom.current().nextInt(1,5)));
        });
    }
}
