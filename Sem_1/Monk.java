package Sem_1;


public class Monk extends Hero { // монах

    boolean haveMagic;
    boolean havePotion;

    public Monk(String name, int health, int strenght, int intuition, int speed, int dexterity, boolean haveMagic, boolean havePotion) {
        super(name, health, strenght, intuition, speed, dexterity);
        this.haveMagic = haveMagic;
        this.havePotion = havePotion;
    }

    public boolean getHaveMagic(){
        return haveMagic;
    }
    
    public boolean getHavePotion(){
        return havePotion;
    }

    @Override
    public void levelUp() {
        super.levelUp();
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getHaveMagic(), getHavePotion());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Magic: %s\nPotion: %s", haveMagic, havePotion);
    }

    public String throwFireball() {
        return String.format("I throw ball lightning");
    }

}
