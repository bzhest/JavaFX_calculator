package com.example.javafx.calculator;

/**
 * Created by DWork on 31.05.2018.
 */
public class Calculator {

    private final Display display;
    private Boolean isLastClickedDigit = false;


    public Calculator(Display display){
        this.display = display;
    }

    public double getNumber() {
        return Double.parseDouble(display.getDisplayedNumber());
    }

    public void setNumber(double number) {
        display.setDisplayedNumber(String.valueOf(number));
    }

    public void showDigit(String digit) {
        if (isLastClickedDigit) {
            display.setDisplayedNumber(display.getDisplayedNumber() + digit);
        } else {
            display.setDisplayedNumber(digit);
        }
        isLastClickedDigit = true;
    }

    public void clear() {
        setNumber(0);
        isLastClickedDigit = false;
    }

    public void getFraction() {
        double newNumber = 1/getNumber();
        setNumber(newNumber);
    }

    public void clickSqrt() {
        double newNumber = Math.sqrt(getNumber());
        setNumber(newNumber);
    }

    public void  doNigate() {
        double newNumber = getNumber() * -1;
        setNumber(newNumber);
    }

    public void clickComma() {
        if (!display.getDisplayedNumber().contains(",") && !display.getDisplayedNumber().contains(".")) {
            display.setDisplayedNumber(display.getDisplayedNumber() + ",");
        }
        isLastClickedDigit = true;
    }
}

