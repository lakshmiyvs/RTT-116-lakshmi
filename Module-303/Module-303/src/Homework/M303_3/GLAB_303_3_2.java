package Homework.M303_3;

import java.util.Scanner;

public class GLAB_303_3_2 {
    public static void main(String[] args) {

        // Scanner

        Scanner input = new Scanner(System.in);
        System.out.print("Enter three words separated by spaces: ");
        String s1 = input.next();
        String s2 = input.next();
        String s3 = input.next();
        System.out.println("s1 is " + s1);
        System.out.println("s2 is " + s2);
        System.out.println("s3 is " + s3);
        System.out.println("****************************************");

        // Reading a String from Console
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String s = input1.nextLine();
        char ch = s.charAt(0);
        System.out.println("The character entered is " + ch);
        System.out.println("****************************************");

    }
}


