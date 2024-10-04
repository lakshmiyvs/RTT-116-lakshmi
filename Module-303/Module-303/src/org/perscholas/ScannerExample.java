package org.perscholas;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        System.out.println("Enter the radius of the circle");

        Scanner scanner = new Scanner(System.in);

        // after scanning a number we need to do a scanner.nextLine() to throw
        // the new line character (which was created when you pressed enter on the keyboard)
        //into the garbage
        //Important
        //when we type this on the keyboard we are actually press 3 keys
        //2
        //0
        //enter
        // the nextDouble() takes the 2 and the 0 and puts it into the variable x
        //the scanner still contains the new line character created when you pressed enter

        double x = scanner.nextDouble();

        // calling next line after nextDouble will consume the new line character from the scanner
        // and essentially throw it in the garbage .. this will leave the scanner empty so the next time the
        // user enters data we can capture it without having leftovers from the previous call

        scanner.nextLine();

        System.out.println("You have entered a radius of " + x);

        double area = x * x * 3.14159;

        System.out.println("The area of the circle is " + area);

        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println(name);

    }
}
