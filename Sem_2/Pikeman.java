package Sem_2;

public class Pikeman extends Hero { //копейщик

    int lenghtSpear;
    boolean haveShield;

    public Pikeman(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int lenghtSpear, boolean haveShield) {
        super(name, x, y, health, strenght, intuition, speed, dexterity);
        this.lenghtSpear = lenghtSpear;
        this.haveShield = haveShield;
    }

    public Pikeman(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20);
        this.lenghtSpear = 200;
        this.haveShield = true;
    }

    public int getLenghtSpear(){
        return lenghtSpear;
    }
    
    public boolean getHaveShield(){
        return haveShield;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.lenghtSpear += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getLenghtSpear(), getHaveShield());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Lenght Spear: %d\nShield: %s", lenghtSpear, haveShield);
    }

    public String spearBlow() {
        return String.format("I hit with a spear!!!");
    }
}
