package Sem_1;

public class Peasant extends Hero { //крестьянин

    private String craft;
    private int power;

    public Peasant(String name, int health, int strenght, int intuition, int speed, int dexterity, String craft, int power) {
        super(name, health, strenght, intuition, speed, dexterity);
        this.craft = craft;
        this.power = power;
    }

    public String getCraft(){
        return craft;
    }
    
    public int getPower(){
        return power;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.power += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s and my craft is %s. I`m your %s.", getName(), getCraft(), this.getClass().getSimpleName());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Craft: %s\nPower: %d", craft, power);
    }

    public String digPotatoes() {
        return String.format("Potatoes, so many potatoes!!!");
    }
}
