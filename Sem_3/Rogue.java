package Sem_3;

public class Rogue extends Hero { //разбойник

    int secrecy;
    int repute;

    public Rogue(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative, int secrecy, int repute) {
        super(name, x, y, health, strenght, intuition, speed, dexterity, initiative);
        this.secrecy = secrecy;
        this.repute = repute;
    }

    public Rogue(String name, int x, int y) {
        super(name, x, y, 100, 20, 20, 10, 20, 2);
        this.secrecy = 40;
        this.repute = 55;
    }

    public int getSecrecy(){
        return secrecy;
    }
    
    public int getRepute(){
        return repute;
    }

    @Override
    public void levelUp() {
        super.levelUp();
        this.secrecy += 10;
        this.repute += 10;
    }

    @Override
    public String toString() {
        return String.format("Hi, master! My name is %s. I`m your %s.", getName(), this.getClass().getSimpleName(), getSecrecy(), getRepute());
    }

    @Override
    public String showMyCharacteristics() {
        return super.showMyCharacteristics() + String.format("Secrecy: %d\nRepute: %d", secrecy, repute);
    }

    public String deceive() {
        return String.format("I deceived you");
    }

    @Override
    public void step() {
        System.out.println(String.format("%s steped...", this.getClass().getSimpleName()));
    }
}
