package M303_5;

import java.util.ArrayList;
import java.util.List;

public class ForLoopExamples {
    public static void main(String[] args) {

        // this is the original 1970s for loop and it works great for when you want to count
        // or to do something a set number of times
        // this is also good for positioning within an array or string

        // counting up
        for (int count = 1; count < 10; count++) {
            System.out.println("For loop iteration " + count);
        }

        // count down
        for (int count = 10; count >= 1; count--) {
            System.out.println("For loop iteration " + count);
        }

        // the array is 0 based  so that means the position in the array are from 0 to 4
        String[] strings = { "one", "two", "three", "four", "five" };

        // old style for loop
        // note that array.length is used without ()
        for( int pos = 0 ; pos < strings.length ; pos++ ) {
            System.out.println( "strings at position" + pos + " = " + strings[pos]);
        }

        // looping over the characters in a string
        String characters = "abcdefg";

        // not that string.length() does use the ()
        for (int pos = 0; pos < characters.length(); pos++) {
            System.out.println("characters at position" + pos + " = " + characters.charAt(pos));
        }

        // looping over a list
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");

        // not that the list uses .size() to get the number of elements in the list
        for ( int pos = 0 ; pos < stringList.size() ; pos++ ) {
            // we are using the .get function to get a element of the list by its position
            String value = stringList.get(pos);
            System.out.println("strings at position" + pos + " = " + value);
        }

        // new style for loop for array
        for ( String value : strings ) {
            System.out.println("new style for loop for an array : " + value);
        }

        // new style for loop
        // read this in my mind   for string in stringList
        // this for loop is easier to type and read but does not contain position in the list that each item came from
        // which is okay in lots of cases
        for ( String string : stringList ) {
            System.out.println("new for loop " + string);
        }

    }
}
