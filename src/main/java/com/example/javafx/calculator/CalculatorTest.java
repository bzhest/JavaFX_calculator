package com.example.javafx.calculator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by DWork on 31.05.2018.
 */
public class CalculatorTest {

    private Calculator calculator;
    private boolean lastButtonWasDigit;

    private Display display = new DisplayStub();

    public boolean isLastButtonWasDigit() {
        return lastButtonWasDigit;
    }

    @BeforeMethod
    public void setUp() throws Exception {
        calculator = new Calculator(display);
    }

    @Test
    public void testGetNumber() throws Exception {
        //given
        display.setDisplayedNumber("0.0");
        //when
        double number = calculator.getNumber();
        //then
        Assert.assertEquals(number, 0D);
    }




    @Test()
    public void testSetNumber() throws Exception {
        //given
        double number = 42;
        //when
        calculator.setNumber(number);
        //then
        Assert.assertEquals(calculator.getNumber(), number);
    }

    @Test
    public void testShowDigit() throws Exception {
        Assert.assertEquals(display.getDisplayedNumber(),"0");
        calculator.showDigit("1");
        Assert.assertEquals( display.getDisplayedNumber(),"1");
        calculator.showDigit("2");
        Assert.assertEquals(display.getDisplayedNumber(),"12");

    }

    @Test
    public void testClear() throws Exception {
        //given
        calculator.showDigit("1");
        //when
        calculator.clear();
        //then
        calculator.isLastClickedDigit()
        Assert.assertEquals(display.getDisplayedNumber(),"0");
    }

    @Test
    public void testGetFraction() throws Exception {
    }

    @Test
    public void testClickSqrt() throws Exception {
    }

    @Test
    public void testDoNigate() throws Exception {
    }

    @Test
    public void testClickComma() throws Exception {
    }

    private static class DisplayStub implements Display {
        private String displayNumber = "0";

        @Override
        public String getDisplayedNumber() {
            return displayNumber;
        }

        @Override
        public void setDisplayedNumber(String displayedNumber) {
            this.displayNumber = displayedNumber;
        }
    }

    @DataProvider
    public Object[][] numbers() {
        return new Object[][]{
                {-100000}, {-1}, {0}, {1}, {1000000}
        };
    }
}