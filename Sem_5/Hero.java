package Sem_5;

import java.util.ArrayList;
import java.util.Random;

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

    private Random random;

    public Hero(String name, int x, int y, int health, int strenght, int intuition, int speed, int dexterity, int initiative) {
        this.name = name;
        this.position = new Position(x, y);
        this.health = health;
        this.strenght = strenght;
        this.intuition = intuition;
        this.speed = speed;
        this.dexterity = dexterity;
        this.initiative = initiative;

        random = new Random();
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

    public int[] getCoords() {
        return new int[] { this.position.getX(), this.position.getY() };
    }

    public int getHp() {
        return this.health;
    }

    public abstract String getInfo();

    public void getHit(int power) {
        this.health -= power;
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
    
    public String attack(Hero currentHero, int id, ArrayList<Hero> heroes) {
        int power = generateAttackPoints();
        String voice = "";
        if (power == 0) {
            voice = generateRandomBlockVoice().replace("#H1#", currentHero.getName()).replace("#H2#", heroes.get(id).getName());
            return String.format("%s.", voice);
        } else {
            heroes.get(id).getHit(power);
            voice = generateRandomAttackVoice().replace("#H1#", heroes.get(id).getName()).replace("#H2#", currentHero.getName());
            String result = String.format("%s. -%d", voice, power);
            if (heroes.get(id).getHealth() <= 0) {
                result += String.format(" %s пал от рук кровожадного %s. Теперь его дозор окончен...", heroes.get(id).getName(), currentHero.getName());
                heroes.remove(id);
                result += String.format(" В этой команде осталось [%d] Викингов", heroes.size());
            }
            return result;
        }
    }

    public String defense(String defenseVoice) {
        return String.format("%s %s defends himself: %s", this.getClass().getSimpleName(), getName(), defenseVoice);
    }

    public String myPosition() {
        return String.format("My position is: (%d, %d).", getPosition().getX(), getPosition().getY());
    }

    public int getIdHeroByPosition(ArrayList<Hero> heroes, Position position) {
        int id = -1;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getPosition().getX() == position.getX() && heroes.get(i).getPosition().getY() == position.getY()) {
                id = i;
                break;
            }
        }
        return id;
    }
    
    public Position findNearestEnemy(ArrayList<Hero> heroes) {
        int minI = 0;
        float minDistance = heroes.get(minI).getDistance(getPosition());
        for (int i = 1; i < heroes.size(); i++){
            float curDistance = heroes.get(i).getDistance(getPosition());
            if (curDistance < minDistance){
                minDistance = curDistance;
                minI = i;
            };            
        }
        return heroes.get(minI).getPosition();
    }

    private int generateAttackPoints() {
        double da = random.nextDouble();
        return (int)(da * this.strenght);
    }

    private String generateRandomAttackVoice() {
        return AttackEnum.getRandomAttack();
    }

    private String generateRandomBlockVoice() {
        return BlockEnum.getRandomBlock();
    }

    private boolean canMove(ArrayList<Hero> heroes, Position position) {
        boolean result = true;
        for (Hero hero : heroes) {
            Position herPosition = hero.getPosition();
            if (herPosition.getX() == position.getX() && herPosition.getY() == position.getY()) {
                result = false;
            }
        }
        return result;
    }

    private void moveHero(Position currentPosition, int dy, int dx, String hero) {
        MyView.MatrixCoordination[currentPosition.getY()][currentPosition.getX()] = "*";
        MyView.MatrixCoordination[currentPosition.getY() + dy][currentPosition.getX() + dx] = hero;
    }

    // Каждый герой может перемещаться по полю только живой
    // Алгоритм движения, если dX > dY двигаемся по x иначе по y
    @Override
    public String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam) {
        if (this.getHealth() > 0) {
            Position nearestEnemy = findNearestEnemy(heroes);
            int dx = currentPosition.getX() - nearestEnemy.getX();
            int dy = currentPosition.getY() - nearestEnemy.getY();
            // Двигаемся или атакуем
            if (Math.abs(dx) > 1 || Math.abs(dy) > 1) {
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0) {
                        if (canMove(myTeam, new Position(currentPosition.getX() - 1, currentPosition.getY()))) {
                            currentPosition.setX(currentPosition.getX() - 1);
                            moveHero(currentPosition, 0, -1, this.getInfo());
                        } else {
                            return String.format("%s пропускает ход, не может двинуться...", this.getName());
                        }
                    } else {
                        if (canMove(myTeam, new Position(currentPosition.getX() + 1, currentPosition.getY()))) {
                            currentPosition.setX(currentPosition.getX() + 1);
                            moveHero(currentPosition, 0, 1, this.getInfo());
                        } else {
                            return String.format("%s пропускает ход, не может двинуться...", this.getName());
                        }
                    }
                } else {
                    if (dy > 0) {
                        if (canMove(myTeam, new Position(currentPosition.getX(), currentPosition.getY() - 1))) {
                            currentPosition.setY(currentPosition.getY() - 1);
                            moveHero(currentPosition, -1, 0, this.getInfo());
                        } else {
                            return String.format("%s пропускает ход, не может двинуться...", this.getName());
                        }
                    } else {
                        if (canMove(myTeam, new Position(currentPosition.getX(), currentPosition.getY() + 1))) {
                            currentPosition.setY(currentPosition.getY() + 1);
                            moveHero(currentPosition, 1, 0, this.getInfo());
                        } else {
                            return String.format("%s пропускает ход, не может двинуться...", this.getName());
                        }
                    }
                }
                return String.format("%s переместился. Новая позиция: (%d, %d)", this.getName(), currentPosition.getX(), currentPosition.getY());
            // Атакуем
            } else {
                return attack(this, getIdHeroByPosition(heroes, nearestEnemy), heroes);
            }
        } else {
            return String.format("%s is dead...", this.getName());
        }
    }

    @Override
    public int compareTo(Hero to) {
        int compareInitiative = ((Hero)to).getInitiative();
        return compareInitiative - this.initiative;
    }
}
