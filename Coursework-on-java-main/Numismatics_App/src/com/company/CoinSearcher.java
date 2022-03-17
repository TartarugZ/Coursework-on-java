package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CoinSearcher {


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




    public void testCountries(Elements countries) {

        System.out.println(countries.size());

        countries.forEach(scope->{

            String rwer=scope.text();

            System.out.print(rwer+", ");


        });
        System.out.println();

    }


}