package M303_9;

import java.util.ArrayList;
import java.util.List;

public class CalcRunner {
    public static void main(String[] args) {

        Circle c = new Circle();
        c.setRadius(10.0);    // this is implemented
        c.setName("Circle"); // this is implemented in the shape class
        //System.out.println(c.getName() + " = " + c.getPI());

        Circle c1 = new Circle();
        c1.setRadius(15.0);
        c1.setName("Circle 1");
        // when the object is created PI should be 3.14 but becuase
        // we changed on c and it is a static variable it is also 4 here
        //System.out.println(c1.getName() + " = " + c1.getPI());

        Triangle t = new Triangle();
        t.setBase(10.0);
        t.setHeight(10.0);
        t.setName("Triangle");

        // make a list of shape but notice that we are using the parent shape
        List<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(c1);
        shapes.add(t);

        // lets loop over all the shapes and calculate the area
        for (Shape s : shapes) {
            double area = s.calculateArea();
            double perimeter = s.calculatePerimeter();

            //when something has been typecasted to its parent we can still check to
            //see if it is a Triangle
            if (s instanceof Triangle) {
                System.out.println("s is of type Triangle");
            }
            System.out.println("The Area for shape = " + s.getName() + " is " + area);
        }

    }
}
