package Homework.M303_4;

import static java.lang.Math.PI;

public class PA_303_4_1 {

    public static void main(String[] args) {

        // 1st and 2nd problem using if-else method
        int x = 12;
        if (x < 10) {
            System.out.println("x is less then 10");
        } else {
            System.out.println("x is greater then 10");

            int y = 10;

            if (y < 10) {
                System.out.println("y is less then 10");
            } else if (y > 10 && y < 20) {
                System.out.println("Between 10 and 20");
            } else if (y >= 20) {
                System.out.println("Greater than or equal to 20");
            }

            int radius = 10;
            if (radius >= 0) {
                double area = radius * radius * PI;
                System.out.println("The area of a circle of "
                        + "radius " + radius + " is " + area);

            }
        }
    }
}

