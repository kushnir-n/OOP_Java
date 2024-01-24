package Sem_5;

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
        return String.format("Мой господин! Я %s. Моя специальность %s.", getName(), this.getClass().getSimpleName(), getDartsCount(), getAccuracy());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Darts count: %d\nAccurancy: %d", dartsCount, accuracy);
    }

    public String fatalShot() {
        return String.format("You have no chance to survive");
    }

    @Override
    public Position findNearestEnemy(ArrayList<Hero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).getDistance(getPosition());
        for (int i = 1; i < heroes.size(); i++){
            float curDistance = heroes.get(i).getDistance(getPosition());
            if (curDistance < minDistance){
                minDistance = curDistance;
                minI = i;
            };            
        }
        return heroes.get(minI).getPosition();
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
        return "C";
    }
}
