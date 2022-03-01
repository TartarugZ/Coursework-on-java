package com.company;

import org.jsoup.Jsoup;


import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;
import org.jsoup.nodes.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {

    private static String country = "germany";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {





        //Scanner scanCountry = new Scanner(System.in);
        //System.out.println("Enter country");
       // String country = scanCountry.nextLine();

        ArrayList<String> titles = new ArrayList<>();
        Document doc = Jsoup.connect("https://en.ucoin.net/catalog/?country=croatia").get();
        Elements title = doc.getElementsByAttributeValue("class","value");

        title.forEach(scope->{

            // Element rty = scope.child(0);

            
            String rwer=scope.text();

            System.out.println();

            System.out.println(rwer);
            System.out.println();System.out.println();


        });







    }
}
