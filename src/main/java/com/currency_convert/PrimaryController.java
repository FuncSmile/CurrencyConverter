package com.currency_convert;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML
    private ComboBox<String> countryComboBox;

    @FXML
    private ComboBox<String> countryComboBoxResult;

    @FXML
    private TextField fieldUser;

    @FXML
    private TextField fieldHasil;

    ObservableList<String> Countries = FXCollections.observableArrayList("IDR", "USD", "EUR");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        countryComboBox.setItems(Countries);
        countryComboBoxResult.setItems(Countries);
        countryComboBox.getSelectionModel();
        countryComboBoxResult.getSelectionModel();

        // Event kalau ComboBox dipilih
        countryComboBox.setOnAction(e -> convertCurrency());

        // Event kalau user ngetik di fieldUser
        fieldUser.setOnKeyReleased(e -> convertCurrency());
    }

    private void convertCurrency() {
        String selectedCurrency = getSelectedComboBoxString();
        String selectedResultCurrency = getSelectedResultComboBoxString();
        String inputText = fieldUser.getText();

        try {
            double inputValue = Double.parseDouble(inputText);

            double result = 0;

            if ("USD".equals(selectedCurrency) && "USD".equals(selectedResultCurrency)) {
                result = inputValue;
            } else if ("USD".equals(selectedCurrency) && "IDR".equals(selectedResultCurrency)) {
                result = inputValue * 16000;
            } else if ("USD".equals(selectedCurrency) && "EUP".equals(selectedResultCurrency)) {
                result = inputValue * 0.87;
            } else if ("EUP".equals(selectedCurrency) && "USD".equals(selectedResultCurrency)) {
                result = inputValue * 1.15;
            } else if ("EUP".equals(selectedCurrency) && "EUP".equals(selectedResultCurrency)) {
                result = inputValue;
            } else if ("EUP".equals(selectedCurrency) && "IDR".equals(selectedResultCurrency)) {
                result = inputValue * 19000;
            } else if ("IDR".equals(selectedCurrency) && "USD".equals(selectedResultCurrency)) {
                result = inputValue * 0.01;
            } else if ("IDR".equals(selectedCurrency) && "EUP".equals(selectedResultCurrency)) {
                result = inputValue * 0.01;
            } else if ("IDR".equals(selectedCurrency) && "IDR".equals(selectedResultCurrency)) {
                result = inputValue;
            }
            fieldHasil.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            fieldHasil.setText(""); // kosongin kalau input gak valid
        }
    }

    public String getSelectedComboBoxString() {
        return countryComboBox.getSelectionModel().getSelectedItem();
    }

    public String getSelectedResultComboBoxString() {
        return countryComboBoxResult.getSelectionModel().getSelectedItem();
    }

}
