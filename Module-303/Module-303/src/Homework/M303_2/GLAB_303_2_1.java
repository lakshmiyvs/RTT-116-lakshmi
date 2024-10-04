package Homework.M303_2;

public class GLAB_303_2_1 {
    public static void main(String[] args) {

        //Arithmetic Operators Demo
        int x;
        int y = 10;
        int z = 5;
        x = y + z;
        System.out.println("+ operator resulted in " + x);
        x = y - z;
        System.out.println("- operator resulted in " + x);
        x = y * z;
        System.out.println("* operator resulted in " + x);
        x = y / z;
        System.out.println("/ operator resulted in " + x);
        x = y % z;
        System.out.println("% operator resulted in " + x);
        x = y++;
        System.out.println("Postfix ++ operator resulted in " + x);
        x = ++z;
        System.out.println("Prefix ++ operator resulted in " + x);
        x = -y;
        System.out.println("Unary operator resulted in " + x);
        // Some examples of special Cases
        int tooBig = Integer.MAX_VALUE + 1; // -2147483648 which is
        // Integer.MIN_VALUE.
        int tooSmall = Integer.MIN_VALUE - 1; // 2147483647 which is
        // Integer.MAX_VALUE.
        System.out.println("tooBig becomes " + tooBig);
        System.out.println("tooSmall becomes " + tooSmall);
        System.out.println(4.0 / 0.0); // Prints: Infinity
        System.out.println(-4.0 / 0.0); // Prints: -Infinity
        System.out.println(0.0 / 0.0); // Prints: NaN
        double d1 = 12 / 8; // result: 1 by integer division. The value of d1 becomes 1.0.
        double d2 = 12.0F / 8; // result: 1.5
        System.out.println("d1 is " + d1);
        System.out.println("d2 is " + d2);
        System.out.println("-------------------------------------------------------");
        //Assignment Operators Demo

        int j, k;
        j = 10; // j gets the value 10.
        j = 5; // j gets the value 5. The previous value is overwritten.
        k = j; // k gets the value 5.
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);
        //              Multiple Assignments
        k = j = 10; // (k = (j = 10))
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);
        System.out.println("-------------------------------------------------------");

        //Logical Operators Demo

        boolean m = true;
        boolean n = false;
        System.out.println("x & y : " + (m & n));
        System.out.println("x && y : " + (m && n));
        System.out.println("x | y : " + (m | n));
        System.out.println("x || y: " + (m || n));
        System.out.println("x ^ y : " + (m ^ n));
        System.out.println("!x : " + (!m));
        System.out.println("-------------------------------------------------------");

        //Relational Operators Demo
        int a = 10, b = 5;
        System.out.println("a > b : "+(a > b));
        System.out.println("a < b : "+(a < b));
        System.out.println("a >= b : "+(a >= b));
        System.out.println("a <= b : "+(a <= b));
        System.out.println("a == b : "+(a == b));
        System.out.println("a != b : "+(a != b));

        int variable1 = 50, variable2 = 100, variable3 = 50;
        System.out.println("variable1 = " + variable1);
        System.out.println("variable2 = " + variable2);
        System.out.println("variable3 = " + variable3);
        System.out.println("variable1 == variable2: "
                + (variable1 == variable2));

        System.out.println("variable1 == variable3: "
                + (variable1 == variable3));
        System.out.println("-------------------------------------------------------");

        //Ternary Operators Demo
        int age = 18;
        String result = age < 100 ?
                "Less than 100" : "Greater than 100";
        System.out.println(result); //Less than 100
        System.out.println("-------------------------------------------------------");

        //Unary Operator
        int sum = +1;
        // sum is now 1
        System.out.println(sum);

        sum--;
        // sum is now 0
        System.out.println(sum);

        sum++;
        // sum is now 1
        System.out.println(sum);
        sum = -sum;
        // sum is now -1
        System.out.println(sum);

        boolean result1 = false;
        // false
        System.out.println(result);
        // true
        System.out.println(!result1);



    }
}
