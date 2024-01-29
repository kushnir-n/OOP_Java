import java.util.ArrayList;

public class Peasant extends Hero { //крестьянин

    private String craft;
    private int power;
    private boolean ready;

    public Peasant(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, String craft, int power) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.craft = craft;
        this.power = power;
    }

    public Peasant(String name, int x, int y) {
        super(name, x, y, 200, 5, 20, 10, 20, 0);
        this.craft = "Warrior";
        this.power = 50;
        this.ready = true;
    }

    public String getCraft(){
        return craft;
    }
    
    public int getPower(){
        return power;
    }

    public boolean getReady() {
        return this.ready;
    }

    public void setBusy () {
        this.ready = false;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.power += 10;
    }

    @Override
    public String toString() {
        return String.format("Мой господин! Я %s. Моя специальность %s. Моё ремесло %s. Позиция (%d, %d)", getName(), this.getClass().getSimpleName(), getCraft(), getPosition().getX(), getPosition().getY());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Craft: %s\nPower: %d", craft, power);
    }

    @Override
    public String getInfo() {
        return "p";
    }

    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        this.ready = true;
        return String.format("Крестьянин %s хорошо отдохнул и говорит стрелкам, что он готов!", getName());
    }

    public String digPotatoes() {
        return String.format("Potatoes, so many potatoes!!!");
    }
}
