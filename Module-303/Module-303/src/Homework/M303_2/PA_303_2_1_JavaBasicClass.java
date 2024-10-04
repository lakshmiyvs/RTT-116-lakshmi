package Homework.M303_2;

import java.text.DecimalFormat;

public class PA_303_2_1_JavaBasicClass {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        // Adding two integer numbers
        int sum = num1 + num2;
        System.out.println("The sum of two Integers is: " + sum);
        System.out.println("******************************");


        double num3 = 15.5;
        double num4 = 20.5;
        // Adding two double numbers
        double sum1 = num3 + num4;
        System.out.println("The sum of two doubles is: " + sum1);
        System.out.println("******************************");

        // Adding double and Integer values together
        double sum2 = num1 +  num3 ;
        System.out.println("The sum of an integer and a double is: " + sum2);
        System.out.println("******************************");

        // Determine the int larger and smaller number
        int larger = Math.max(num1, num2);
        int smaller = Math.min(num1, num2);
        // Dividing Integer big number with small number
        int result = larger / smaller;
        System.out.println("Integer division result: " + result);

        // Change the larger number to a double
        double largerDecimal = 10.0;
        double decimalResult = largerDecimal / smaller;
        System.out.println("Decimal division result: " + decimalResult);
        System.out.println("******************************");

        // Determine the larger and smaller number
        double large = Math.max(num3, num4);
        double small = Math.max(num3, num4);
        // Dividing double large number with small number
        double result1 = large / small ;
        System.out.println("Double Division result: " + result1);

        // Casting a double into integer and dividing it
        //int intresult2 = (int)large / (int)small;
        int intresult2 = (int) result1;
        System.out.println("casting double result to int result: " + intresult2);
        System.out.println("******************************");

        int x = 5;
        int y = 6;
        int q = y/x;
        System.out.println("Integer division result: " + q);
        // Cast y to a double and perform division
        double result3 = (double) y / x;
        System.out.println("Casting Int Y to Double division : " + result3);
        System.out.println("******************************");

        // Calculate the RectangleArea by Named Constant
        final double INCH_TO_CM = 2.54;
        double lengthInInches = 10;
        double widthInInches = 5;
        double lengthInCm = lengthInInches * INCH_TO_CM;
        double widthInCm = widthInInches * INCH_TO_CM;
        // Calculate the area in square centimeters
        double area = lengthInCm * widthInCm;

        // Print the result
        System.out.println("The area of the rectangle in square centimeters is: " + area);
        System.out.println("******************************");

        //Problem 8 Calculating Total Sales

        double coffeePrice = 2.50;
        double greenTeaPrice = 3.15;
        double espressoPrice = 4.25;

        int coffeeqty = 3;
        int greenTeaqty = 4;
        int espressoqty = 2;

        double subTotal = (coffeePrice * coffeeqty) + (greenTeaPrice * greenTeaqty) + (espressoPrice * espressoqty);

        final double SALES_TAX = 0.08;

        double totalSale = subTotal + (subTotal * SALES_TAX);
        // Format the result to 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("SubTotal: $" + subTotal);
        System.out.println("Total Sales with Tax: $" + df.format(totalSale));












    }
}
