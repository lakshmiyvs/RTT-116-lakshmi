package M303_4;

public class LeapYear {

    public static void main(String[] args) {
        int year = 1992;

        if (year % 4 == 0 && year % 100 > 0 && year % 400 == 0) {
            System.out.println("Leap Year");
        } else {
            System.out.println("Not a Leap Year");
        }

        // grades
        int marks = 80;
        if( marks > 70 )
            System.out.println("Distinction");
        if( marks > 35 )
            System.out.println("Pass");
        else
            System.out.println("Fail");
        System.out.println("Better luck next time");

        int grade = 90;

        if (grade >= 90) {
            System.out.println("A");
        } else if (grade >= 80) {
            System.out.println("B");
        } else if (grade >= 70) {
            System.out.println("C");
        } else if (grade >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        // case statement / switch statement
        switch (grade) {
            case 90: {
                System.out.println("you got a 90");
                break;
            }
            case 80: {
                System.out.println("you got a 80");
                break;
            }
            default: {
                System.out.println("you did not get 80 or 90");
                // this is the else if no other conditions are met
            }
        }
    }
}