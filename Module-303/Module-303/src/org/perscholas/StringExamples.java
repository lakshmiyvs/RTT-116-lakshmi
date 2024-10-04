package org.perscholas;

import java.util.StringJoiner;
import java.text.DecimalFormat;

public class StringExamples {

    public static void main(String[] args) {

        // the total length of the string is 6 characters
        // 0 based indexing
        //          0123456
        String s = "abcdef";

        //this will print the length of the string
        System.out.println("The length of the string is " + s.length());

        //this will print the string in upper case
        System.out.println("Uppercase = " + s.toUpperCase());

        //this will concat the string manually
        String concat = s.concat("ghijk");
        System.out.println(concat);

        System.out.println(s.charAt(0));
        System.out.println(s.charAt(5));
        System.out.println(s.charAt(3));
        System.out.println(s.charAt(4));

        String r = "abc123abc";
        //replace a with z
        System.out.println(r.replace('a', 'z'));

        //replace abc with xyz
        System.out.println(r.replace("abc", "xyz"));

        // replaceAA uses a regular expression
        System.out.println(r.replaceAll("\\d", "9"));

        //SUBSTRING

        String filename = "someimage.jpg";

        System.out.println(filename.substring(0,4));
        System.out.println(filename.substring(1,5));

        //when we use a single argument with substring it is simply the starting position and it will take
        // the rest of the string
        System.out.println(filename.substring(4));

        //when we want to print out the index of the . in the string
        //index of finds the first occurrence of what ever your looking for
        System.out.println("The . is in position " + filename.indexOf("."));

        //lastIndexOf will find the last index of what ever you are looking for
        // this can also be taught of search from the left to right instead of right to left
        //so to get the file extension we can use a combination of substring and lastIndexOf
        System.out.println(filename.substring(filename.lastIndexOf(".")));

        //challenge .... how do i get just the filename without the extension
        System.out.println(filename.substring(0,filename.lastIndexOf(".")));

        // !!!!! ALWAYS USE .equals when comparing 2 strings !!!!!
        String s1 = new String( "abc");
        String s2 = new String( "ABC");

        // !!!!!!! VERY VERY IMPORTANT
        // this is never correct for strings
        System.out.println(s1 == s2 ); // this will print false because they are different

        //Always correct way to compare 2 strings is always to use the .equals
        // doing it any other way is ALWAYS WRONG
        System.out.println(s1.equalsIgnoreCase(s2));

        // convert from string to number
        String n = "101";
        // this will take the string 101 and convert it to the number one hundred and one
        Integer n1 = Integer.parseInt(n);

        //this method can throw an exception because the string may not contain only numbers
        //Integer n3 = Integer.parseInt("1234abc");

        //converting from a number to a string is easy
        String n2 = n1.toString();

        System.out.println(n2.toString());

        //!!!! IMPORTANT - String in Java are immutable - meaning they can be changed after they are created
        String s4 = "abc";
        String s5 = "123";

        // when s4.toUpperCase is called it creates another brand new string in memory that is ABC
        // it did not modify s4 .. it created a new string
        // then it concatinates on the string s5 when creates yet another new string in memory that is assigned
        //to variables s6
        String s6 = s4.toUpperCase() + s5;

        //**************StringBuffer***************

        //The StringBuffer is mutable meaning the internal content of the StringBuffer can be changed and it is good to use
        //when doing lots of string manipulation is a high volume system
        StringBuffer sb = new StringBuffer();

        // append will add something to the end of the string and it has the same effect as conct for strings
        // there 2 lines of code are the equivalent of doing "abc" + "123" or using the .concat method on a string

        // 01234567890
        //abc1xyz23

        sb.append("abc");
        sb.append("123");

        //know this for the KBA
        // this will start insert at position 4
        sb.insert(4,"xyz");

        // replace function for string buffer
        //start at position 0 and goto position 3 ( but not include position 3)
        //may be its easier to think about replace as 2 operations
        //operations1) starting at position 0 and going to position 3 be deleted
        //operation 2) starting at position 0 the string will be inserted
        // so ..... starting at position 0 and going to position3 is 3 characters that will essentially be deleted
        sb.replace(0,3,"ABCDEF");
        System.out.println(sb.toString());

        // we can delete from a string buffer
        sb.delete(0,3);
        System.out.println(sb.toString());

        //not sure anyone would use this in a work environment but it exists
        //this just reverse the entire string
        sb.reverse();

        //KBA Question.... study this section code so you can get the KBA question correct

        // 01234567890123456789
        // ABC
        // DEFG
        // 12345DEFG
        // GFED54321
        // 4321

        StringBuffer kba = new StringBuffer("ABC");
        kba.replace(0,7,"DEFG").insert(0,"12345");
        kba.reverse();
        kba.delete(0,5);

        System.out.println(sb.toString());

        //************ String Joiner **************

        // KBA Questions to study..... this is a memorize thing
        // This is about 90% the same as the KBA question
        // a string joiner formats the list of strings and seperats each one with a delimeter
        // but not put a delimeter at the end of the line
        StringJoiner joinNames = new StringJoiner("|","{","}");

        StringJoiner sj1 = new StringJoiner("|","{","}");
        StringJoiner sj2 = new StringJoiner("|","{","}");

        sj1.add("Eric");
        sj1.add("Jessica");

        System.out.println(sj1);

        sj2.add("Jeff");
        sj2.add("John");

        System.out.println(sj2);

        System.out.println(sj1.merge(sj2).toString());

        joinNames.add("Eric");
        joinNames.add("John");
        joinNames.add("Jane");
        joinNames.add("Bob");
        System.out.println(joinNames);


        //********************** Formatting *******************

        int i = 1024;
        byte b = 127;
        double d = 1.232, tiny = d / 1000000.0;
        boolean bool = true;
        System.out.format(" This is an integer: %d and this is a byte: %d and one more variable %d \n", i, b, 10);
        System.out.format(" This is a double: %.4f and this is tiny: %.4e.\n", d, tiny);
        System.out.format(" And this is a String: %s", "This is a string.\n");

        //********** Decimal Formating ********************

        // DecimalFormatter exists and makes it easy to format a number nicely
        // it takes in a pattern and will apply that pattern to a number
        // when you need to use it .. you can google it and there will be 50 articles on how to use it
        // it will take 5 minutes to figure out what you need when you need it as long as you can remember
        // that the DecimalFormatter exists.

        String pattern = "$##,###,###.##";
        double number = 123456789.123;

        DecimalFormat numberFormat = new DecimalFormat(pattern);
        System.out.println(numberFormat.format(number));


        //TRIM

        String t = " abc123 ";
        System.out.println("->" + t + "<-");
        System.out.println("->" + t.trim() + "<-");








    }
}
