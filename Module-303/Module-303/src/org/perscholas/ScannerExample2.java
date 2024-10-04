package org.perscholas;

import java.util.Scanner;

public class ScannerExample2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

                // Ask the user to input the first number
                System.out.print("Enter the first number: ");
                int num1 = scanner.nextInt();  // Reads an integer input

                // Ask the user to input the second number
                System.out.print("Enter the second number: ");
                int num2 = scanner.nextInt();  // Reads another integer input

                // Add the two numbers
                int sum = num1 + num2;

                // Print the result
                System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

                // Close the scanner to prevent resource leak
                scanner.close();
            }
        }





