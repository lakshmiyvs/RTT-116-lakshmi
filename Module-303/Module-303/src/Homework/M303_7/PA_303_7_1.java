package Homework.M303_7;

import java.util.Arrays;
import java.util.Scanner;

public class PA_303_7_1 {

    public static void main(String[] args) {
        int[] num = new int[3];
        num[0] = 1;
        num[1] = 5;
        num[2] = 8;

        System.out.println("Using for Loop:");
        for (int i = 0; i < num.length; i++) {
            System.out.println("Element" + i + ":" + num[i]);
        }
        System.out.println("**********************************************");

        // Problem 2- Return the middle element of the array

        int[] numbers = {13, 5, 7, 68, 2, 5};

        // to find the middle element
        int arrayLength = numbers.length / 2;

        // Print the middle element
        System.out.println("The middle element is: " + numbers[arrayLength]);
        System.out.println("********************************************");

        // Problem 3- String Array and clone it and print

        String[] colors = {"red", "green", "blue", "yellow", "pink"};

        // print the array length
        System.out.println("Array length:" + colors.length);
        // clone the array
        String[] colorsClone = colors.clone();

        // Print the original results and cloned results
        System.out.println("Original array: " + Arrays.toString(colors));
        System.out.println("Cloned array: " + Arrays.toString(colorsClone));
        System.out.println("**********************************************");

        // Problem 4-

        int[] myArray = {10, 20, 30, 40, 50};

        // print total length
        System.out.println("Total length: " + myArray.length);

        // Print the first element (index 0)
        System.out.println("First element: " + myArray[0]);

        // Print the last element (index length - 1)
        System.out.println("Last element: " + myArray[myArray.length - 1]);

        // Access an invalid index (index equal to array length)
        // This will cause an ArrayIndexOutOfBoundsException
        //System.out.println("Element at index length: " + myArray[myArray.length]);

        // Try to assign a value to index 5 (out of bounds)
        // This will also cause an ArrayIndexOutOfBoundsException
        //myArray[5] = 100;
        // System.out.println("Element at index length: " + myArray[myArray.length]);

        // Problem -5 Array Loops

        int[] array = new int[5];  // Create an integer array of length 5

        // Loop through the array and assign the loop control variable value to each index
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        System.out.println("Original array: " + Arrays.toString(array));
        System.out.println("****************************************");

        // Problem 6- Array multiplied by loop

        int[] array1 = new int[5];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = i * 2;
        }
        System.out.println("Original array: " + Arrays.toString(array1));
        System.out.println("****************************************");

        // Problem 7- print array without the middle element

        for (int i = 0; i < array1.length; i++) {
            if (i == 2) {
                continue;  // Skip the middle element
            }
            System.out.println(array1[i]);
        }
        System.out.println("*****************************************");

        // Problem 8- Swap first array with middle array without creating a new array

        int temp = array1[0];
        array1[0] = array1[2];
        array1[2] = temp;
        System.out.println("Original array: " + Arrays.toString(array1));
        System.out.println("******************************************");

        // Problem 9- sort array in ascending order

        int[] Array2 = {4, 2, 9, 13, 1, 0};
        Arrays.sort(Array2);
        System.out.print("Array in ascending order:");
        for (int i = 0; i < Array2.length; i++) {
            System.out.print(Array2[i]);
        }
        System.out.println();
        System.out.println("The smallest element is: " + Array2[0]);
        System.out.println("The largest element is: " + Array2[Array2.length - 1]);
        System.out.println("*****************************************");

        // Problem 10- Printing 1 integer, 3 strings, 1 double
        Object[] array3 = {42, "apple", "banana", "cherry", 3.14};  // Create an array with mixed types

        // Print the array
        for (Object obj : array3) {
            System.out.print(obj + " ");
        }

        System.out.println("*************************************");


        // Problem 11 - User Inpput and printing the array

        Scanner scanner = new Scanner(System.in);

        System.out.print("How many favorite things you have: ");
        int numOfThings = scanner.nextInt();
        scanner.nextLine();

        // Create a String array of the correct size
        String[] favoriteThings = new String[numOfThings];

        // Ask the user to enter their favorite things
        for (int i = 0; i < numOfThings; i++) {
            System.out.print("Enter your thing: ");
            favoriteThings[i] = scanner.nextLine();
        }

        // Print out the contents of the array
        System.out.println("Your favorite things are: " + Arrays.toString(favoriteThings));

        scanner.close();


    }
}
