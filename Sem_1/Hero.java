package Sem_1;

// Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах". +
//Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию наследников. 
// Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. 
// В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя. 
// Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

public abstract class Hero {

    private int health, strenght, intuition, speed, dexterity;
    private String name;

    public Hero(String name, int health, int strenght, int intuition, int speed, int dexterity) {
        this.name = name;
        this.health = health;
        this.strenght = strenght;
        this.intuition = intuition;
        this.speed = speed;
        this.dexterity = dexterity;
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

    public void levelUp() {
        this.health += 25;
        this.strenght += 1;
        this.intuition += 1;
        this.speed += 5;
        this.dexterity += 1;
    }

    public String showMyCharacteristics() {
        return String.format("I`m %s\nMy name is %s\nHealth: %d\nStrenght: %d\nIntuition: %d\nSpeed: %d\nDexterity: %d\n", 
        this.getClass().getSimpleName(), getName(), getHealth(), getStrenght(), getIntuition(), getSpeed(), getDexterity());
    }
    
    public String Attack(String attackVoice) {
        return String.format("%s %s attacks: %s", this.getClass().getSimpleName(), getName(), attackVoice);
    }

    public String Defense(String defenseVoice) {
        return String.format("%s %s defends himself: %s", this.getClass().getSimpleName(), getName(), defenseVoice);
    }
}
