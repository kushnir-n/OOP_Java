package heroes;

public class Pikeman extends Hero { //копейщик

    int lenghtSpear;
    boolean haveShield;

    public Pikeman(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int lenghtSpear, boolean haveShield) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.lenghtSpear = lenghtSpear;
        this.haveShield = haveShield;
    }

    public Pikeman(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 2);
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
        return String.format("Мой господин! Я %s. Моя специальность %s. Позиция (%d, %d)", getName(), this.getClass().getSimpleName(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Lenght Spear: %d\nShield: %s", lenghtSpear, haveShield);
    }

    @Override
    public String getInfo() {
        return "P";
    }

    public String spearBlow() {
        return "I hit with a spear!!!";
    }
}
