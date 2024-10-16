package Homework.PA_303_10_1;

public class FireMonster extends Monster {
    public FireMonster(String name) {
        super(name);
    }

    // Overriding attack method for FireMonster
    @Override
    public String attack() {
        return "Attacks with fire!";
    }
}
