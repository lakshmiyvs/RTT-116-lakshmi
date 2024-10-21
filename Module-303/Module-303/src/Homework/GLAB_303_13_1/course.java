package Homework.GLAB_303_13_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class course {
    private String code, course_name, instructor_name;
    public course (String code, String name, String instructor) {
        this.code = code;
        this.course_name = name;
        this.instructor_name = instructor;
    }
    public course () {
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }
}
class MyRunner {

    public static void main(String[] args) throws FileNotFoundException {

        try {
//-----  change file path, as per your file location
            String location = "C:\\Users\\yvsla/CourseData.csv";
            File file = new File(location);
            Scanner input = new Scanner(file);
            ArrayList<course> data = new ArrayList<course>();

            while (input.hasNextLine()) {
                String Line = input.nextLine();
                String[] splitedLine = Line.split(",");

// course cObj1 = new course(splitedLine[0], splitedLine[1], splitedLine[2]);
                course cObj = new course();
                cObj.setCode(splitedLine[0]);
                cObj.setCourse_name( splitedLine[1]);
                cObj.setInstructor_name(splitedLine[2]);

                data.add(cObj);
            }

            for (course c : data) {
                System.out.println(c.getCode() + " | " + c.getCourse_name() + "|" + c.getInstructor_name());
                System.out.println("===============================");
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found! ");
            e.printStackTrace();
        }
    }
}


