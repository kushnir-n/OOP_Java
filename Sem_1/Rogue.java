package Sem_1;

public class Rogue extends Hero { //разбойник

    int secrecy;
    int repute;

    public Rogue(String name, int health, int strenght, int intuition, int speed, int dexterity, int secrecy, int repute) {
        super(name, health, strenght, intuition, speed, dexterity);
        this.secrecy = secrecy;
        this.repute = repute;
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
}
