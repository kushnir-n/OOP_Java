package Sem_3;


// Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах". +
// Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию наследников. 
// Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. 
// В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя. 
// Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

public abstract class Hero implements Stepable, Comparable<Hero> {

    private int health, strenght, intuition, speed, dexterity;
    private String name;
    private Position position;
    private int initiative;

    public Hero(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative) {
        this.name = name;
        this.position = new Position(x, y);
        this.health = health;
        this.strenght = strenght;
        this.intuition = intuition;
        this.speed = speed;
        this.dexterity = dexterity;
        this.initiative = initiative;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getInitiative() {
        return initiative;
    }

    public Position getPosition() {
        return this.position;
    }

    public float getDistance(Position position) {
        return this.position.calculateDistance(position);
    }

    public void levelUp() {
        this.health += 25;
        this.strenght += 1;
        this.intuition += 1;
        this.speed += 5;
        this.dexterity += 1;
    }

    public String showMyCharacteristics() {
        return String.format("I`m %s\nMy name is %s\nMy position: (%d, %d)\nHealth: %d\nStrenght: %d\nIntuition: %d\nSpeed: %d\nDexterity: %d\n", 
        this.getClass().getSimpleName(), getName(), getPosition().getX(), getPosition().getY(), getHealth(), getStrenght(), getIntuition(), getSpeed(), getDexterity());
    }
    
    public String attack(String attackVoice) {
        return String.format("%s %s attacks: %s", this.getClass().getSimpleName(), getName(), attackVoice);
    }

    public String defense(String defenseVoice) {
        return String.format("%s %s defends himself: %s", this.getClass().getSimpleName(), getName(), defenseVoice);
    }

    public String myPosition() {
        return String.format("My position is: (%d, %d).", getPosition().getX(), getPosition().getY());
    }

    @Override
    public void step() {
        System.out.println("Hero steped");
    }

    @Override
    public int compareTo(Hero to) {
        int compareInitiative = ((Hero)to).getInitiative();
        return compareInitiative - this.initiative;
    }
}
