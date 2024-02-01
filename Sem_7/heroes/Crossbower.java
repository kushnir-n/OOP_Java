package heroes;

import common.Position;

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
        super(name, x, y, 100, 10, 20, 10, 20, 3);
        this.dartsCount = 0;
        this.accuracy = 20;
    }

    public int getDartsCount() {
        return dartsCount;
    }

    public void setDartsCount(int d) {
        this.dartsCount += d;
    }
    
    public int getAccuracy() {
        return accuracy;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setDartsCount(10);
        this.accuracy += 10;
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s. Количество стрел: %d Позиция (%d, %d)", getName(), this.getClass().getSimpleName(), getDartsCount(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Darts count: %d\nAccuracy: %d", dartsCount, accuracy);
    }

    public String fatalShot() {
        return "You have no chance to survive";
    }

    private void findPeasantAndGetDart(ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero instanceof Peasant) {
                if (((Peasant) hero).getReady()) {
                    setDartsCount(1);
                    ((Peasant) hero).setBusy();
                    break;
                }
            }
        }
    }

    public boolean checkPeasants(ArrayList<Hero> heroes) {
        int cnt = 0;
        for (Hero hero : heroes) {
            if (hero instanceof Peasant) {
                cnt++;
            }
        }
        return cnt > 0;
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        findPeasantAndGetDart(myTeam);
        if (this.getHealth() > 0) {
            if (this.getDartsCount() > 0) {
                Position nearestEnemy = findNearestEnemy(heroes);
                setDartsCount(-1);
                return attack(this, getIdHeroByPosition(heroes, nearestEnemy), heroes);
            } else {
                if (checkPeasants(myTeam)) {
                    return String.format("Я %s. У меня закончились стрелы! Нужен крестьянин!", getName());
                } else {
                    System.out.printf("%s грутсно посмотрел на колчан и пошёл биться тетивой!\n", getName());
                    return super.step(currentPosition, heroes, myTeam);
                }
            }
        } else {
            return String.format("%s is dead...", this.getName());
        }
    }

    @Override
    public String getInfo() {
        return "C";
    }
}
