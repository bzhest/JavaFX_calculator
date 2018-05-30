package com.example.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;
    private Boolean isLastClickedDigit = false;

    public void clickBackSpace(ActionEvent actionEvent) {
    }

    public void clickDigit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String digit = button.getText();
        if (isLastClickedDigit) {
            setDisplayedNumber(getDisplayedNumber() + digit);
        } else {
            setDisplayedNumber(digit);
        }
        isLastClickedDigit = true;
        System.out.println("Displayed number is " + getDisplayedNumber());
    }

    public String getDisplayedNumber() {
        return display.getText();
    }

    public void setDisplayedNumber(String displayedNumber) {
        display.setText(displayedNumber);
    }

    public void buttonClear(ActionEvent actionEvent) {
        setDisplayedNumber("0");
        isLastClickedDigit = false;
    }
}
