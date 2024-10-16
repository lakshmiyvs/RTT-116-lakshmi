package Homework.PA_303_10_3;

public class LibraryInterfaceDemo {

        public static void main(String[] args) {
            // Test case #1: KidUser
            KidUser kidUser = new KidUser();

            // Age 10
            kidUser.setAge(10);
            kidUser.registerAccount();

            // Age 18
            kidUser.setAge(18);
            kidUser.registerAccount();

            // BookType "Kids"
            kidUser.setBookType("Kids");
            kidUser.requestBook();

            // BookType "Fiction"
            kidUser.setBookType("Fiction");
            kidUser.requestBook();

            System.out.println(); // For better readability

            // Test case #2: AdultUser
            AdultUser adultUser = new AdultUser();

            // Age 5
            adultUser.setAge(5);
            adultUser.registerAccount();

            // Age 23
            adultUser.setAge(23);
            adultUser.registerAccount();

            // BookType "Kids"
            adultUser.setBookType("Kids");
            adultUser.requestBook();

            // BookType "Fiction"
            adultUser.setBookType("Fiction");
            adultUser.requestBook();
        }
    }

