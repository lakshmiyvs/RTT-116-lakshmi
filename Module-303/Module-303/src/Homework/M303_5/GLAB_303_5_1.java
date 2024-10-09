package Homework.M303_5;

import java.util.Scanner;

public class GLAB_303_5_1 {
    public static void main(String[] args) {
        int n = 5;
        // for loop
        for (int i = 1; i <= n; i++) {
            System.out.println("Java is fun");
        }
        System.out.println("*******************************************");

        // Display Sum of n Natural Numbers

        int sum = 0;
        int N = 1000;
        // for loop
        for (int I = 1; I <= N; ++I) {
            // body inside for loop
            sum += I;     // sum = sum + i
        }
        System.out.println("Sum = " + sum);
        System.out.println("*******************************************");

        // PALINDROME Example

        String original, reverse = ""; // Objects of String class
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it is a palindrome");
        original = in.nextLine();
        int length = original.length();
        for (int i1 = length - 1; i1 >= 0; i1--)
            reverse = reverse + original.charAt(i1);
        if (original.equals(reverse)) {
            System.out.println("Entered string/number is a palindrome.");
        } else {
            System.out.println("Entered string/number isn't a palindrome.");
        }
        System.out.println("*******************************************");

        // PYRAMID

        for (int x = 1; x <= 5; x++) {
            for (int j = 1; j <= x; j++) {
                System.out.print("* ");
            }
            System.out.println();//new line

        }

    }
}


