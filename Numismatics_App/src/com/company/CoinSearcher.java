package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

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

        //testCountries(countries);

    }


    public  void smartCoutrySelection(String country){

        System.out.println("im working");

    }



    public String getCounrtyLink(String requiredCountry){  //возвращает нужную часть http ссылки на определенную страну
                                                          // название стран в каталоге и их название в http сслыке отличается, поэтому этот метод более чем необходим

        Elements listOfCountries = doc.getElementsByAttributeValue("class","cntry");

        for(Element oneComparedCountry: listOfCountries){

            Elements ytr = oneComparedCountry.getElementsByAttributeValue("class","left wrap nopad");

             if(requiredCountry.equals(
                             oneComparedCountry
                             .getElementsByAttributeValue("class","left wrap nopad")
                             .text())
             ) {
                 return  oneComparedCountry.select("a[href]").attr("href");
             }



        };

        return "Not found, something wrong";

    }



    public void testgetCounrtyLink(){

        String link = getCounrtyLink("Germany");
        System.out.println(link);


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