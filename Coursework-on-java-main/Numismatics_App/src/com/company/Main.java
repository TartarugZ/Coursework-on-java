package com.company;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import org.jsoup.nodes.Document;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;



public class Main {

    //private static String country = "germany";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {





        //Scanner scanCountry = new Scanner(System.in);
        //System.out.println("Enter country");
        //String country = scanCountry.nextLine();
       // Collection collection = new Collection("Croatia");
        //ArrayList<String> titles = new ArrayList<>();



        CoinSearcher searcher = new CoinSearcher();
        Coin coin =createCoin( "country","currency","value","category",null,"linkUcoin");

        LocalDate date =coin.getDataOfCreate();
         System.out.println(date);


    }

    public static Coin createCoin(String country, String currency, String value, String category, Optional <Float> costActual, String linkUcoin){


    Coin coin = new Coin(country,currency,value, category,costActual,linkUcoin);

    return coin;

    };

    public void addCoinToCollection(Collection collection,Coin coin){

        collection.addToCollection(coin);

    };
}
