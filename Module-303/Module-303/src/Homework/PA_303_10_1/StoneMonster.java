package Homework.PA_303_10_1;

public class StoneMonster extends Monster {
    public StoneMonster(String name) {
        super(name);
    }

    // Overriding attack method for StoneMonster
    @Override
    public String attack() {
        return "Attacks with stones!";
    }
}
