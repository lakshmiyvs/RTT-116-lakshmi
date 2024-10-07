package Homework.M303_3;

import java.util.Arrays;

public class GLAB_303_3_1 {
    public static void main(String[] args) {

        // Length Method

          String str1 = "Java";
        String str2 = "";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println("Java".length());  // 4
        System.out.println("Java\n".length()); // 5
        System.out.println("Learn Java".length()); // 10
        System.out.println("****************************************");

         // IsEmpty() Method

        String s1="";
        String s2="hello";
        System.out.println(s1.isEmpty());      // true
        System.out.println(s2.isEmpty());      // false
        System.out.println("****************************************");

        // Trim() Method

        String a1="  hello   ";
        System.out.println(a1+"how are you");        // without trim()
        System.out.println(a1.trim()+"how are you"); // with trim()
        System.out.println("****************************************");

        // toLowerCase() Method

        String b1="HELLO HOW Are You?";
        String b1lower=b1.toLowerCase();
        System.out.println(b1lower);
        System.out.println("****************************************");

        // Java String toUpper() method:

        String c1="hello how are you";
        String c1upper=c1.toUpperCase();
        System.out.println(c1upper);
        System.out.println("****************************************");

        // concat() method
        //------By using concat method----
        String str3 = "Learn ";
        String str4 = "Java";
        // concatenate str1 and str2
        System.out.println(str3.concat(str4)); // "Learn Java"

        // concatenate str2 and str11
        System.out.println(str4.concat(str3)); // "JavaLearn "
        //--- By using + operator---
        String s3 =  "hello";
        String s4 = "Learners";
        //  String s5 = s3.concat(s4); or
        String s5 = s3 + s4;
        //both of the above statement will give you the same result
        System.out.println(s5);

        // Three strings are concatenated
        String message = "Welcome " + "to " + "Java";
        System.out.println(message);

        // String Chapter is concatenated with number 2
        String s = "Chapter" + 2; // s becomes Chapter2
        System.out.println(s);

        // String Supplement is concatenated with character B
        String S1 = "Supplement" + 'B'; // s1 becomes SupplementB
        System.out.println(S1);
        System.out.println("****************************************");

        // split() method
        String vowels = "a::b::c::d:e";

        // splitting the string at "::"
        // storing the result in an array of strings
        String[] result = vowels.split("::");

        // converting array to string and printing it
        System.out.println("result = " + Arrays.toString(result));
        System.out.println("****************************************");

        // charAt() method: Getting Characters From a String
        String message1 = "Welcome to Java";
        System.out.println("The first character in the message is " + message1.charAt(0));
        System.out.println("****************************************");

        // compareTo() method:
        String q1="hello";
        String b2="hello";
        String c3="hemlo";
        String d4="flag";
        System.out.println(a1.compareTo(b2)); // 0 because both are equal
        System.out.println(a1.compareTo(c3)); //-1 because "l" is only one time lower than "m"
        System.out.println(a1.compareTo(d4)); // 2 because "h" is 2 times greater than "f"
        System.out.println("****************************************");

        // Substrings() method:
        String string1 = "java is fun";

        // extract substring from index 0 to 3
        System.out.println(string1.substring(0, 4));
        System.out.println("****************************************");

        // indexOf() method:
        String st1 = "Java is fun";
        int result1;

        // getting index of character 's'
        result1 = st1.indexOf('s');

        System.out.println(result1); // 6

        // getting index of character 'J'
        result1 = st1.lastIndexOf('J');
        System.out.println(result1); // 0
        // the last occurrence of 'a' is returned
        result1 = st1.lastIndexOf('a');
        System.out.println(result1); // 3

        // character not in the string
        result1 = st1.lastIndexOf('j');
        System.out.println(result1); // -1

        // getting the last occurrence of "ava"
        result1 = st1.lastIndexOf("ava");
        System.out.println(result1); // 1

        // substring not in the string
        result1 = st1.lastIndexOf("java");
        System.out.println(result1); // -1
        System.out.println("****************************************");

        // contains() method:
        String stri1 = "Learn Java";
        Boolean result2;

        // check if str1 contains "Java"
        result2 = stri1.contains("Java");
        System.out.println(result2);  // true

        // check if str1 contains "Python"
        result2 = stri1.contains("Python");
        System.out.println(result2);  // false

        // check if str1 contains ""
        result2 = stri1.contains("");

        System.out.println(result2);  // true
        System.out.println("****************************************");

        // replace() method
        String st2 = "abc cba";

        // all occurrences of 'a' is replaced with 'z'
        System.out.println(st2.replace('a', 'z'));

        // all occurences of 'L' is replaced with 'J'
        System.out.println("Lava".replace('L', 'J'));
        // character not in the string
        System.out.println("Hello".replace('4', 'J'));
        // all occurrences of "C++" is replaced with "Java"
        System.out.println(st2.replace("C++", "Java"));

        // all occurences of "aa" is replaced with "zz"
        System.out.println("aa bb aa zz".replace("aa", "zz"));

        // substring not in the string
        System.out.println("Java".replace("C++", "C"));
        System.out.println("****************************************");

        // Java String replaceAll()

        String st3 = "Java123is456fun";

        // regex for sequence of digits
        String regex = "\\d+";

        // replace all occurrences of numeric
        // digits by a space
        System.out.println(st3.replaceAll(regex, " "));
        System.out.println("****************************************");

        // By Using equals() Method
        String k1="PerScholas";
        String l2="PerScholas";
        String m3=new String("PerScholas");
        String n4="Teksystem";
        System.out.println(k1.equals(l2));//true
        System.out.println(k1.equals(m3));//true
        System.out.println(k1.equals(n4));//false
        System.out.println("****************************************");

        // By Using == operator
        String t1="Perscholas";
        String u2="Perscholas";
        String v3=new String("Perscholas");
        System.out.println(t1==u2);//true (because both refer to same instance)
        System.out.println(t1==v3);//false(because s3 refers to instance created in nonpool)
        System.out.println("****************************************");

        // By Using compareTo() method
        String e1="Perscholas";
        String f2="Perscholas";
        String g3="Perschola";
        String h4="PerscholasX";
        System.out.println(e1.compareTo(f2)); //0
        System.out.println(e1.compareTo(g3)); // 1(because s1>s3)
        System.out.println(e1.compareTo(h4)); // -1(because s1<s4 )
        System.out.println("****************************************");

    }
}
