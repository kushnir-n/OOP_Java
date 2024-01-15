package Sem_3;


public class Peasant extends Hero { //крестьянин

    private String craft;
    private int power;

    public Peasant(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, String craft, int power) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.craft = craft;
        this.power = power;
    }

    public Peasant(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 0);
        this.craft = "Warrior";
        this.power = 50;
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

    @Override
    public void step() {
        System.out.println(String.format("%s steped...", this.getClass().getSimpleName()));
    }
}
