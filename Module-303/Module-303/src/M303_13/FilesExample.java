package M303_13;

import java.io.File;

public class FilesExample {
    public static void main(String[] args) {

        //main constructor usage is the name
        File file = new File("src");
        System.out.println(file.getAbsolutePath());
        System.out.println("exists: " + file.exists());
        System.out.println("is Directory: " + file.isDirectory());
        System.out.println("is Hidden: " + file.isHidden());
        System.out.println("can read " + file.canRead());
        System.out.println("can write " + file.canWrite());
        System.out.println("can execute " + file.canExecute());
        System.out.println("size" + file.length());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println("====> " + f.getName());
            }
        }
    }
}
