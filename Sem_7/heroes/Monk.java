package heroes;

import common.Position;

import java.util.ArrayList;

public class Monk extends Hero { // монах

    boolean hasMagic;
    boolean hasWine;

    public Monk(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, boolean hasMagic, boolean hasWine) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.hasMagic = hasMagic;
        this.hasWine = hasWine;
    }

    public Monk(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 1);
        this.hasMagic = true;
        this.hasWine = true;
    }

    public boolean getHasMagic(){
        return hasMagic;
    }
    
    public boolean getHasWine(){
        return hasWine;
    }

    public void setHasWine(){
        this.hasWine = false;
    }

    public String throwFireball() {
        return "I throw ball lightning";
    }

    private boolean checkTeam(ArrayList<Hero> heroes) {
        int cnt = 0;
        for (Hero hero : heroes) {
            if (hero instanceof Wizard) {
                cnt++;
            }
        }
        return cnt > 0;
    }

    @Override
    public void levelUp() {
        super.levelUp();
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s. Позиция (%d, %d)", getName(), this.getClass().getSimpleName(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Magic: %s\nPotion: %s", hasMagic, hasWine);
    }

    @Override
    public String getInfo() {
        return "M";
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        if (checkTeam(myTeam)) {
            this.hasWine = true;
            return String.format("Я %s. У меня наполнена чаша вина! Ай да ко мне!", getName());
        } else {
            System.out.printf("%s отхлебнул из своей чаши, осмелел и побежал в драку...\n", getName());
            return super.step(currentPosition, heroes, myTeam);
        }
    }
}
