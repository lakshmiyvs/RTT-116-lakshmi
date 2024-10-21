package M303_13;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerWriter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try{
            File file = new File("src/temp2.txt");
            PrintWriter pw = new PrintWriter(new FileWriter(file,true));
            System.out.println("Enter a string to write to the file: ");

            String input = scanner.nextLine();

            pw.println(input);

            pw.flush();
            System.out.println(input);

            pw.flush();
        } catch ( Exception e ) {
        }
    }
}
