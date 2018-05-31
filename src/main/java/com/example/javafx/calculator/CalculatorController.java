package com.example.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField display;
    private Boolean isLastClickedDigit = false;

    public double getNumber() {
        return Double.parseDouble(getDisplayedNumber());
    }

    public void setNumber(double number) {
        setDisplayedNumber(String.valueOf(number));
    }

    public String getDisplayedNumber() {
        return display.getText();
    }

    public void setDisplayedNumber(String displayedNumber) {
        display.setText(displayedNumber);
    }

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

    public void buttonClear(ActionEvent actionEvent) {
        setNumber(0);
        isLastClickedDigit = false;
    }

    public void buttonCommaClick(ActionEvent actionEvent) {
        if (!getDisplayedNumber().contains(",") && !getDisplayedNumber().contains(".")) {
            setDisplayedNumber(getDisplayedNumber() + ",");
        }
        isLastClickedDigit = true;
    }

    public void buttonNegate(ActionEvent actionEvent) {
        double newNumber = getNumber() * -1;
        setNumber(newNumber);
    }

    public void buttonSqrtClick(ActionEvent actionEvent) {
        double newNumber = Math.sqrt(getNumber());
        setNumber(newNumber);
    }

    public void getFraction(ActionEvent actionEvent) {
        double newNumber = 1/getNumber();
        setNumber(newNumber);
    }
}
