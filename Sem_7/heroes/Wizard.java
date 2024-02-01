package heroes;

import common.Position;
import enums.ElementEnum;

import java.util.ArrayList;

public class Wizard extends Hero { // колдун

    int wisdom, mana;
    ElementEnum element;

    public Wizard(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int mana, int wisdom, ElementEnum element) {
       super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
       this.mana = mana;
       this.wisdom = wisdom;
       this.element = element;    
    }

    public Wizard(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 1);
        this.mana = 5;
        this.wisdom = 50;
        this.element = ElementEnum.Air;
    }

    public int getWisdom(){
        return wisdom;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int m) {
        mana += m;
    }

    public ElementEnum getElemet(){
        return element;
    }

    public boolean checkMonks(ArrayList<Hero> heroes) {
        int cnt = 0;
        for (Hero hero : heroes) {
            if (hero instanceof Monk) {
                cnt++;
            }
        }
        return cnt > 0;
    }

    private void findMonkAndGetWine(ArrayList<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero instanceof Monk) {
                if (((Monk) hero).getHasWine()) {
                    setMana(2);
                    ((Monk) hero).setHasWine();
                    break;
                }
            }
        }
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        findMonkAndGetWine(myTeam);
        if (getHealth() > 0) {
            if (getMana() >= 5) {
                Position nearestEnemy = findNearestEnemy(heroes);
                setMana(-5);
                return attack(this, getIdHeroByPosition(heroes, nearestEnemy), heroes);
            } else {
                if (checkMonks(myTeam)) {
                    return String.format("Я %s. Моя чаша пуста! Надо срочно вина!", getName());
                } else {
                    System.out.printf("%s: Без вина и битва не та :-(\n", getName());
                    return super.step(currentPosition, heroes, myTeam);
                }
            }
        } else {
            return String.format("%s is dead...", getName());
        }
    }
    
    @Override
    public void levelUp() {
        super.levelUp();
        this.wisdom += 10;
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s. Я маг %s. Позиция (%d, %d).", getName(), this.getClass().getSimpleName(), getElemet(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Wisdom: %d\nElement: %s", wisdom, element);
    }

    @Override
    public String getInfo() {
        return "W";
    }

    public String disappear() {
        return "I disappeared";
    }
}
