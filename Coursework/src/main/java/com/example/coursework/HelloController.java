package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML  private Label welcomeText;
    @FXML  private TextArea TF1;
    @FXML  private TextArea TF2;
    @FXML  private TextField TA;
    @FXML  private TextField TA1;
    @FXML  private TableView<Coin> tableviewCountry;
    @FXML  private TableView<Coin> tableviewYears;
    @FXML  private TableColumn<Coin,String> Country;
    @FXML  private TableColumn<Coin,String> Years;
    @FXML  private TableColumn<Coin,String> toilet;

    private final ObservableList<Coin> dataListCounty = FXCollections.observableArrayList();
    private final ObservableList<Coin> dataListYears = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() throws IOException, StringIndexOutOfBoundsException{

        welcomeText.setText("Welcome to JavaFX Application!");
        for(int i=0;i<CoinSearcher.CC.size();i++){
            TF1.appendText(CoinSearcher.CC.get(i).getCountry()+" "+CoinSearcher.CC.get(i).getYears()+"\n");
        }
    }

    public void search() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Country.setCellValueFactory(new PropertyValueFactory<>("Country"));
        Years.setCellValueFactory(new PropertyValueFactory<>("Years"));

        dataListCounty.addAll(CoinSearcher.CC);
        dataListYears.addAll(CoinSearcher.CC);

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Coin> filteredDataCountry = new FilteredList<>(dataListCounty, b -> true);
        FilteredList<Coin> filteredDataYears = new FilteredList<>(dataListYears, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        TA.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataCountry.setPredicate(coin -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (coin.getCountry().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                }else if(coin.getYears().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                }
                else
                    return false; // Does not match.
                if(TA.getText().charAt(TA.getText().length()-1)==' '){
                    TA1.textProperty().addListener((obser, oldValu, newValu) -> {
                        filteredDataYears.setPredicate(van -> {
                            // If filter text is empty, display all persons.
                            if (newValu == null || newValu.isEmpty()) {
                                return true;
                            }
                            // Compare first name and last name of every person with filter text.
                            String lowerCaseFilter = newValu.toLowerCase();
                            if(coin.getYears().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                                return true;
                            }else
                                return false; // Does not match.
                        });
                    });
                }

            });
        });
        TA1.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredDataYears.setPredicate(coin -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                if(coin.getYears().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                    return true;
                }else
                    return false; // Does not match.
            });
        });

        SortedList<Coin> sortedDataCountry = new SortedList<>(filteredDataCountry);
        SortedList<Coin> sortedDataYears = new SortedList<>(filteredDataYears);

        sortedDataCountry.comparatorProperty().bind(tableviewCountry.comparatorProperty());
        sortedDataYears.comparatorProperty().bind(tableviewYears.comparatorProperty());

        tableviewCountry.setItems(sortedDataCountry);
        tableviewYears.setItems(sortedDataYears);

    }

}