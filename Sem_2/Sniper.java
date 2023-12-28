package Sem_2;

public class Sniper extends Hero { //снайпер

    int accuracy;
    int mask;

    public Sniper(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int accuracy, int mask) {
        super(name, x, y, health, strenght, intuition, speed, dexterity);
        this.accuracy = accuracy;
        this.mask = mask;
    }

    public Sniper(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20);
        this.accuracy = 40;
        this.mask = 30;
    }

    public int getAccuracy(){
        return accuracy;
    }
    
    public int getMask(){
        return mask;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.accuracy += 10;
        this.mask += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getAccuracy(), getMask());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Accuracy: %d\nMask level: %d", accuracy, mask);
    }

    public String disarm() {
        return String.format("I disarmed you");
    }

}
