package Sem_3;


import java.util.ArrayList;

public class Crossbower extends Hero { //арбалетчик

    int dartsCount;
    int accuracy;

    public Crossbower(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int dartsCount, int accuracy) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.dartsCount = dartsCount;
        this.accuracy = accuracy;
    }

    public Crossbower(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 3);
        this.dartsCount = 100;
        this.accuracy = 20;
    }

    public int getDartsCount() {
        return dartsCount;
    }
    
    public int getAccuracy() {
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
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getDartsCount(), getAccuracy());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Darts count: %d\nAccurancy: %d", dartsCount, accuracy);
    }

    public String fatalShot() {
        return String.format("You have no chance to survive");
    }

    public String findNearestEnemy(ArrayList<Hero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).getDistance(getPosition());
        for (int i = 1; i < heroes.size(); i++){
            float curDistance = heroes.get(i).getDistance(getPosition());
            if (curDistance < minDistance){
                minDistance = curDistance;
                minI = i;
            };            
        }
        return String.format("My nearest enemy is %s. Position: (%d, %d)", heroes.get(minI).getName(), heroes.get(minI).getPosition().getX(), heroes.get(minI).getPosition().getY());
    }

    @Override
    public void step() {
        if (getHealth() > 0) {
            if (getDartsCount() > 0) {
                this.dartsCount -= 1;
                System.out.println(String.format("%s attacked", getName()));
            } else {
                System.out.println("I haven`t more darts...");
            }
        } else {
            System.out.println(String.format("%s is dead", getName()));
        }
    }
}
