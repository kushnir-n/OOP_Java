// Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах". +
// Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию наследников.
// Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
// В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
// Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

// Добавить в проект класс, предназначенный для хранения координат.
// Добавить в абстрактный класс поле, экземпляр класс координат.
// Пробросить координаты через конструкторы наследников так, чтобы создавая объекты вы передавали в параметрах имя и аоординаты.
// Скорректировать алгоритм заполнения комманд.
// Кроме имён каждый персонаж должен иметь координаты.
// Одна комманда находится с левой стороны другая с правой(у=0 и у=9).
// В метод toString лучников добавить поиск ближайшего противника.
// Алгоритм расчёта расстояний реализовать в классе координат

import common.Color;
import common.MyView;
import heroes.Hero;
import service.Service;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<Hero> team1 = new ArrayList<>();
    public static ArrayList<Hero> team2 = new ArrayList<>();

    public static final int DISTANCE = 9;
    public static final int VIKINGS_COUNT = 10;

    public static void main(String[] args) {

        /*
        // для примера
        Peasant hero1 = new Peasant("Alyosha", 1, 1, 100, 20, 30, 50, 20, "Smith", 88);
        System.out.println(hero1);
        System.out.println(hero1.attack("Aaaaaaa!!! Die!!!!"));
        System.out.println(hero1.defense("I`m not afraid you, potatoe!"));
        System.out.println(hero1.digPotatoes());
        System.out.println(hero1.showMyCharacteristics());
        hero1.levelUp();
        System.out.println(hero1.showMyCharacteristics());

        //вывод только имен
        Crossbower hero2 = new Crossbower("Moto-moto", -9, -9, 100, 50, 60, 80, 40, 70, 20);
        System.out.println((hero2));

        Monk hero3 = new Monk("Radomir", -3, 2, 100, 80, 80, 90, 1, true, true);
        System.out.println(hero3);

        Pikeman hero4 = new Pikeman("Serg", -6, 3, 100, 100, 10, 10, 25, 68, false);
        System.out.println(hero4);

        Rogue hero5 = new Rogue("Ko-ko", 5, 2, 100, 3, 100, 100, 100, 80, 90);
        System.out.println(hero5);

        Sniper hero6 = new Sniper("Rik", 1, 8, 100, 85, 95, 95, 74, 35, 52);
        System.out.println(hero6);

        Wizard hero7 = new Wizard("Dimer", 3, 5, 100, 60, 80, 10, 50, 1, ElementEnum.Air);
        System.out.println(hero7);
        */

        /* MyView */

        MyView.MatrixCoordination = new String[VIKINGS_COUNT][DISTANCE];
        Service service = new Service();

        team1 = service.generateTeam(VIKINGS_COUNT, 0, 1, Color.GREEN_BOLD);
        team2 = service.generateTeam(VIKINGS_COUNT, DISTANCE - 1, 2, Color.RED_BOLD);

        Collections.sort(team1);
        Collections.sort(team2);

        service.printTeamsInfo(team1, team2);
        service.battleVikings(team1, team2);
    }
}
