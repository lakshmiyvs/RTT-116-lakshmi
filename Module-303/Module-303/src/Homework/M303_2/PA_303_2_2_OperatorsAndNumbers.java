package Homework.M303_2;

public class PA_303_2_2_OperatorsAndNumbers {
    public static void main(String[] args) {

        int x = 2;
        // Predicted: Decimal = 4, Binary = 100
        x = x << 1;
        System.out.println("2 << 1 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));
        x = 9;
        // Predicted: Decimal = 18, Binary = 10010
        x = x << 1;
        System.out.println("9 << 1 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));
        x = 17;
        // Predicted: Decimal = 34, Binary = 100010
        x = x << 1;
        System.out.println("17 << 1 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));
        x = 88;
        // Predicted: Decimal = 176, Binary = 10110000
        x = x << 1;
        System.out.println("88 << 1 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));
        System.out.println("******************************************************");

        // Right Shift operator
        int x1 = 150;
        // Predicted: Decimal = 37, Binary = 100101
        x = x1 >> 2;
        System.out.println("150 >> 2 : Decimal = " + x1 + ", Binary = " + Integer.toBinaryString(x));

        x1 = 225;
        // Predicted: Decimal = 56, Binary = 111000
        x1 = x1 >> 2;
        System.out.println("225 >> 1 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));

        x1 = 1555;
        // Predicted: Decimal = 388, Binary = 110000100
        x1 = x1 >> 2;
        System.out.println("1555 >> 2 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));

        x1 = 32456;
        // Predicted: Decimal = 176, Binary = 10110000
        x1 = x1 >> 2;
        System.out.println("32456 >> 2 : Decimal = " + x + ", Binary = " + Integer.toBinaryString(x));
        System.out.println("******************************************************");

        // bitwise AND (&) operation

        int X = 7; // Binary = 0111
        int Y = 17; // Binary = 10001
        // Predicted: z = 1, Binary = 00001
        int Z = X & Y;
        System.out.println("X & Y : Decimal = " + Z + ", Binary = " + Integer.toBinaryString(Z));
        System.out.println("******************************************************");

        // bitwise OR (|) operation

        int x2 = 7; // Binary = 0111
        int y = 17; // Binary = 10001
        // Predicted: z = 23, Binary = 10111
        int z = x2 | y;
        System.out.println("x2 | y : Decimal = " + z + ", Binary = " + Integer.toBinaryString(z));
        System.out.println("******************************************************");

        // postfix increment (x++)

        int x3 = 10;
        System.out.println("Before increment: " + x3);
        x3++;
        System.out.println("After increment: " + x3);
        System.out.println("******************************************************");

        // multiple ways to increment

        int x4 = 5;
        System.out.println("Initial value: " + x4);

        // Method 1: Using x++
        x4++;
        System.out.println("After x++: " + x4);

        // Method 2: Using ++x
        ++x4;
        System.out.println("After ++x4: " + x4);

        // Method 3: Using x = x + 1
        x4 = x4 + 1;
        System.out.println("After x4 = x4 + 1: " + x4);
        System.out.println("******************************************************");

        // difference between prefix and postfix increment

        int x5 = 5;
        int y5 = 8;

        // Using prefix increment (++x)
        int sum = ++x5 + y5;
        System.out.println("Using prefix (++x5): Sum = " + sum + ", x5 = " + x5); // Sum = 14

        // Resetting x
        x5 = 5;

        // Using postfix increment (x5++)
        sum = x5++ + y5;
        System.out.println("Using postfix (x5++): Sum = " + sum + ", x5 = " + x5); // Sum = 13

    }
}