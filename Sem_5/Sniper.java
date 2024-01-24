package Sem_5;

import java.util.ArrayList;

public class Sniper extends Hero { //снайпер

    int accuracy;
    int mask;

    public Sniper(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int accuracy, int mask) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.accuracy = accuracy;
        this.mask = mask;
    }

    public Sniper(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 1);
        this.accuracy = 40;
        this.mask = 30;
    }

    public int getAccuracy(){
        return accuracy;
    }
    
    public int getMask(){
        return mask;
    }
    
    public String disarm() {
        return String.format("I disarmed you");
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.accuracy += 10;
        this.mask += 10;
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s.", getName(), this.getClass().getSimpleName(), getAccuracy(), getMask());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Accuracy: %d\nMask level: %d", accuracy, mask);
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        if (this.getHealth() > 0) {
            Position nearestEnemy = findNearestEnemy(heroes);
            return attack(this, getIdHeroByPosition(heroes, nearestEnemy), heroes);
        } else {
            return String.format("%s is dead...", this.getName());
        }
    }

    @Override
    public String getInfo() {
        return "S";
    }
}
