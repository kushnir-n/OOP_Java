package Sem_3;



public class Monk extends Hero { // монах

    boolean haveMagic;
    boolean havePotion;

    public Monk(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, boolean haveMagic, boolean havePotion) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.haveMagic = haveMagic;
        this.havePotion = havePotion;
    }

    public Monk(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 1);
        this.haveMagic = true;
        this.havePotion = true;
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

    @Override
    public void step() {
        System.out.println(String.format("%s steped...", this.getClass().getSimpleName()));
    }
}
