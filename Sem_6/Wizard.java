
public class Wizard extends Hero { // колдун

    int wisdom;
    ElementEnum element;

    public Wizard(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int wisdom, ElementEnum element) {
       super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
       this.wisdom = wisdom;
       this.element = element;    
    }

    public Wizard(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 1);
        this.wisdom = 50;
        this.element = ElementEnum.Air;
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
        return String.format("I disappeared");
    }
}
