package Homework.M303_2;

public class GLAB_303_2_2 {

           // Implicit casting Auto Type Conversion

            public static void main(String[] args) {
            int x = 20;
            double y = 40.5;
            long p = 30;
            float q = 10.60f;
            // int z = x + y; (1) // Error; cannot convert from double to int.
            double z = x + y;
            System.out.println("Sum of two numbers: " + z);

            // long r = p - q; // (2) // Error; cannot convert from float to long.
            float r = p - q;
            System.out.println("Subtraction of two numbers: " + r);
            System.out.println("*********************************************");

            // Automatic Type Promotion
                byte b = 42;
                char c = 'a';
                short s = 1024;
                int i = 50000;
                float f = 5.67f;
                double d = .1234;
            // Expression:
                double result = (f * b) + (i / c) - (d * s);
            //Result after all the promotions are done.
                System.out.println("result = " + result);
                System.out.println("*********************************************");

            //Narrowing Conversion

                double a = 100.04;
                // explicit type casting
                long l = (long)a;
                int k = (int)l;
                System.out.println("Double value "+a);
                System.out.println("Long value "+l);
                System.out.println("Int value "+k);

                byte m;
                int n = 257;
                double dou = 323.142;
                System.out.println("Conversion of int to byte.");
                m = (byte) n;
                System.out.println("n = " + n + " m = " + m);
                System.out.println("Conversion of double to int.");

                n = (int) dou;
                System.out.println("dou = " + dou + " m = " + n);
                System.out.println("Conversion of double to byte.");

                m = (byte) dou;
                System.out.println("dou = " + dou + " m = " + m);
                System.out.println("*********************************************");


            }
    }

