package Homework.M303_5;

import java.util.Scanner;

public class PA_303_5_1 {
    public static void main(String[] args) {

            // Problem 1. Multiplication Table

        for (int i = 1; i <= 12; i++) {
            for (int j = 1; j <= 12; j++) {
                int result = i * j;
                System.out.printf("%10d", result);
            }
            System.out.println();//new line
        }
        System.out.println("***********************************");

        //  Problem 2. Greatest Common Divisor

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = scanner.nextInt();
        int temp = 0;
        int gcd = 0;
        if (n1 > n2) {
            temp = n1;
        } else {
            temp = n2;
        }
        for (int k = 1; k <= temp; k++) {
            if (n1 % k == 0 && n2 % k == 0) {
                gcd = k;
            }
        }
        System.out.println(gcd);
        System.out.println("**********************************");

        // Problem 3. Predict Future Tution

        double ft = 10000; // tuition fees
        int yr = 1;

        while (true) {
            ft *= 1.07;    // 7% increase of tuition every year
            if (ft >= 20000){  //  checking if tuition has doubled
                break;
            }
            yr++;              // increasing the year by 1
        }
        System.out.println(yr);  // Printing the year when tuition got doubled
        System.out.println("**********************************");
    }
}
