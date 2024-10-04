package org.perscholas;

public class Lesson3032 {
    public static void main(String[] args) {
        System.out.print("This is line 1\n");
        System.out.print("This is line 2\n");
        System.out.println("This is line 3");
        System.out.println("This is line 4");

        System.out.println("This is a tab ->\t<-");
        System.out.println("This is a tab -->1\t<-");
        System.out.println("This is a tab -->12\t<-");
        System.out.println("This is a tab -->123\t<-");
        System.out.println("This is a tab -->1234\t<-");

        // we are going to use a \ to escape the " so that java thinks its actually the character
        System.out.println("What happens if we want to have a \" in the string itself");

        // because the \ is the escape character it too needs to be escaped
        System.out.println();
    }
}
