package M303_4;

public class IfStatementsExample {

    public static void main(String[] args) {

        double radius = 15;

        if (radius < 10) {
            System.out.println("Radius greater than 10");
        } else if (radius > 20) {
            System.out.println("Radius greater than 20");
        } else {
            System.out.println("Radius less than or equal to 10");
        }

        System.out.println("Done");

        // ----Booleans

        // if the booleans is set to true... the if not specified if statement will always be checking if true
        boolean save = true;
        if ( save) {
            // the same as saying if ( save == true ) {
            // this will execute when the boolean is true
        }

        // compound conditionals
        // short circuting menas .... in this case if save is false the JVM will not even evaluate the radius
        if ( save && (radius == 50) ) {
            // both conditions are true
        } else {
            // one condition or the other is false or both are false
        }

        //this too will short circuit
        if ( save && (radius == 50) ) {
            // if either condition (or both) are true then execute here
        } else {



        }
    }
}
