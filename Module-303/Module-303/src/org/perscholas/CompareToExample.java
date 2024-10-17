package org.perscholas;

import java.util.ArrayList;
import java.util.List;

public class CompareToExample {
    public static void main(String[] args) {
    // any negative result means less than
    // o mean equals
    // any negative result means greater than

        String s1 = "abc";
        String s2 = "ABC";

        int result = s1.compareTo(s2);
        System.out.println(result);

        Integer i1 = 10;
        Integer i2 = 20;
        result = i1.compareTo(i2);
        System.out.println(result);


    }
}
