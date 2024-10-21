package M303_13;

import java.io.*;

public class WriteFileExample {
    public static void main(String[] args) {

        File file = new File("src/temp1.txt");

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

            bw.write("Line 1\n");
            bw.write("Line 2\n");
            bw.write("Line 3");
            bw.write("more on line 3\n");

            // as we are writing to the file we are actually writing to a buffer in memory
            // when the buffer fills it will automatically write the buffer to the file as a chunk
            // as an engineer

            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
