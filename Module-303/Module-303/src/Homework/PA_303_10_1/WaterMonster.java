package Homework.PA_303_10_1;

public class WaterMonster extends Monster {
    public WaterMonster(String name) {
        super(name);
    }

    // Overriding attack method for WaterMonster
    @Override
    public String attack() {
        return "Attacks with water!";
    }
}
