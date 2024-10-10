package M303_5;

public class StringNullsExample {

    public static void main(String[] args) {

        // null is its built in part of the language
        // no memory has been allocated and this is simply a variable that has no value
        String s = null; // this string does not exist at all
        String s1 = ""; // this string exists as an object in memory and we call functions on it

        System.out.println("The length of s1 = " + s1.length());
        // note that I can still call functions on s1 because its a real object
        s1.trim();
        s1.toUpperCase();

        // we can check if s exists by saying s == null
        if ( s == null ) {
            System.out.println("the variable s does not exist");
        }
        // NullPointerException
        // s.length();
        // check for an empty string
        if ( s == null || s.length() == 0 ) {
            // the string is empty
            System.out.println("the string is empty");
        }

        // doing comparisons .... in java can never compare strings this way will always produce the wrong result
        // however it might fool you sometimes
        if ( s == s1) {
            // this is always wrong

        }
        // this is the correct way of doing string comparison
        // the problem we have .... is that s is null in our case here
        if ( s != null && s.equals(s1)) {
            // then the 2 strings are equal in a safe way
            System.out.println("will never print because null is not equal to empty string");
        }else {
            System.out.println("null is not equal to empty string");
        }

        if (s1.equals(s)) {
            System.out.println("will never print because null is not equal to empty string");
        }else {
            System.out.println("null is not equal to empty string");


        }
    }
}
