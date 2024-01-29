import java.util.ArrayList;

public class Sniper extends Hero { //снайпер

    int accuracy;
    int mask;
    int boltsCount;

    public Sniper(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int boltsCount, int accuracy, int mask) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.boltsCount = boltsCount;
        this.accuracy = accuracy;
        this.mask = mask;
    }

    public Sniper(String name, int x, int y) {
        super(name, x, y, 100, 10, 20, 10, 20, 1);
        this.boltsCount = 0;
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
        return "I disarmed you";
    }

    public int getBoltsCount() {
        return boltsCount;
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

    private void findPeasantAndGetBolt(ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero instanceof Peasant) {
                if (((Peasant) hero).getReady()) {
                    this.boltsCount++;
                    ((Peasant) hero).setBusy();
                    break;
                }
            }
        }
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.accuracy += 10;
        this.mask += 10;
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s. Количество дротиков %d. Позиция (%d, %d)", getName(), this.getClass().getSimpleName(), getBoltsCount(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Accuracy: %d\nMask level: %d", accuracy, mask);
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        findPeasantAndGetBolt(myTeam);
        if (this.getHealth() > 0) {
            if (this.getBoltsCount() > 0) {
                Position nearestEnemy = findNearestEnemy(heroes);
                return attack(this, getIdHeroByPosition(heroes, nearestEnemy), heroes);
            } else {
                if (checkPeasants(myTeam)) {
                    return String.format("Я %s. У меня закончились стрелы! Нужен крестьянин!", getName());
                } else {
                    return super.step(currentPosition, heroes, myTeam);
                }
            }
        } else {
            return String.format("%s is dead...", this.getName());
        }
    }

    @Override
    public String getInfo() {
        return "S";
    }
}
