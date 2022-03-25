package com.example.coursework;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {


         newCoinSearch();
        //HelloController.search();
        launch();

        Coin coin =createCoin( "country",1);

    }

    public static Coin createCoin(String country, int years){


        Coin coin = new Coin(country, years);

        return coin;

    };

    public void addCoinToCollection(Collection collection, Coin coin){

        collection.addToCollection(coin);

    };

    public static void newCoinSearch() throws IOException{

        CoinSearcher coinSearcher= new CoinSearcher();

        System.out.println("Enter country");


    }
}