package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;



public class Main {

    //private static String country = "germany";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {






        newCoinSearch();

        //Coin coin =createCoin( "country","currency","value","category",null,"linkUcoin");


    }

    public static Coin createCoin(String country, String currency, String value, String category, Optional <Float> costActual, String linkUcoin){


        Coin coin = new Coin(country,currency,value, category,costActual,linkUcoin);

        return coin;

    };

    public void addCoinToCollection(Collection collection,Coin coin){

        collection.addToCollection(coin);

    };

    public static void newCoinSearch() throws IOException {

        CoinSearcher coinSearcher = new CoinSearcher();



        //Scanner scanCountry = new Scanner(System.in);
        //System.out.println("Enter country");
        //String country = scanCountry.nextLine();*/
        //coinSearcher.smartCoutrySelection(country);
        //coinSearcher.getCounrtyLink("Germany");
        coinSearcher.testgetCounrtyLink();

    }



}
