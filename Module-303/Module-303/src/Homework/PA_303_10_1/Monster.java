package Homework.PA_303_10_1;

public class Monster {
    protected String name;

    // Constructor
    public Monster(String name) {
        this.name = name;
    }

    // Default attack method to be overridden by subclasses
    public String attack() {
        return "!^_&^$@+%$* I don't know how to attack!";
    }
}
