package com.example.javafx.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController implements Display {
    @FXML
    private TextField display;
    private Calculator calculator;

    public CalculatorController(){
        calculator = new Calculator(this);
    }



    @Override
    public String getDisplayedNumber() {
        return display.getText();
    }

    @Override
    public void setDisplayedNumber(String displayedNumber) {
        display.setText(displayedNumber);
    }

    public void clickBackSpace(ActionEvent actionEvent) {
    }

    public void clickDigit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String digit = button.getText();
        calculator.showDigit(digit);
    }



    public void buttonClear(ActionEvent actionEvent) {
        calculator.clear();
    }



    public void buttonCommaClick(ActionEvent actionEvent) {
        calculator.clickComma();
    }



    public void buttonNegate(ActionEvent actionEvent) {
        calculator.doNigate();
    }


    public void buttonSqrtClick(ActionEvent actionEvent) {
        calculator.clickSqrt();
    }



    public void buttonFractionClick(ActionEvent actionEvent) {
        calculator.getFraction();
    }


}
