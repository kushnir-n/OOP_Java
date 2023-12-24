package Sem_1;

public class Crossbower extends Hero { //арбалетчик

    int dartsCount;
    int accuracy;

    public Crossbower(String name, int health, int strenght, int intuition, int speed, int dexterity, int dartsCount, int accuracy) {
        super(name, health, strenght, intuition, speed, dexterity);
        this.dartsCount = dartsCount;
        this.accuracy = accuracy;
    }

    public int getdartsCount(){
        return dartsCount;
    }
    
    public int getAccuracy(){
        return accuracy;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.dartsCount += 10;
        this.accuracy += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getdartsCount(), getAccuracy());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Darts count: %d\nAccurancy: %d", dartsCount, accuracy);
    }

    public String fatalShot() {
        return String.format("You have no chance to survive");
    }
}
