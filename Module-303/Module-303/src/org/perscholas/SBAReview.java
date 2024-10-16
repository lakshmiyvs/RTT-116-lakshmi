package org.perscholas;

public class SBAReview {

    public static void main(String[] args) {

        double[] numbers = {4.3, 5.6, 7.2, 1.4, 5.2, 9.8};

        double sum = 0.0;
        // new style for loop
        for ( double number : numbers) {
            sum = sum + number;
        }

        double average = sum / numbers.length;

        System.out.println("Average is " + average);

    }
}
