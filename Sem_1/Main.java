package Sem_1;

// Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах". +
//Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию наследников. 
// Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. 
// В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя. 
// Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

public class Main {
    public static void main(String[] args) {
        // для примера
        Peasant hero1 = new Peasant("Alyosha", 100, 20, 30, 50, 20, "Smith", 88);
        System.out.println(hero1);
        System.out.println(hero1.Attack("Aaaaaaa!!! Die!!!!"));
        System.out.println(hero1.Defense("I`m not afraid you, potatoe!"));
        System.out.println(hero1.digPotatoes());
        System.out.println(hero1.showMyCharacteristics());
        hero1.levelUp();
        System.out.println(hero1.showMyCharacteristics());
        
        //вывод только имен
        Crossbower hero2 = new Crossbower("Moto-moto", 100, 50, 60, 80, 40, 70, 20);
        System.out.println((hero2));

        Monk hero3 = new Monk("Radomir", 100, 80, 80, 90, 1, true, true);
        System.out.println(hero3);

        Pikeman hero4 = new Pikeman("Serg", 100, 100, 10, 10, 25, 68, false);
        System.out.println(hero4);

        Rogue hero5 = new Rogue("Ko-ko", 100, 3, 100, 100, 100, 80, 90);
        System.out.println(hero5);

        Sniper hero6 = new Sniper("Rik", 100, 85, 95, 95, 74, 35, 52);
        System.out.println(hero6);

        Wizard hero7 = new Wizard("Dimer", 100, 60, 80, 10, 50, 1, ElementEnum.Air);
        System.out.println(hero7);

    }
}
