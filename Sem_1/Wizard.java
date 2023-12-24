package Sem_1;

public class Wizard extends Hero { // колдун

    int wisdom;
    ElementEnum element;

    public Wizard(String name, int health, int strenght, int intuition, int speed, int dexterity, int wisdom, ElementEnum element) {
       super(name, health, strenght, intuition, speed, dexterity);
       this.wisdom = wisdom;
       this.element = element;    
    }

    public int getWisdom(){
        return wisdom;
    }

    public ElementEnum getElemet(){
        return element;
    }
    
    @Override
    public void levelUp() {
        super.levelUp();
        this.wisdom += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getWisdom(), getElemet());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Wisdom: %d\nElement: %s", wisdom, element);
    }

    public String disappear() {
        return String.format("I disappeared");
    }

}
