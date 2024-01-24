package Sem_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Service {

    public ArrayList<Hero> generateTeam(int count, int x, int team) {

        int cCnt = 1, mCnt = 1, peCnt = 1, piCnt = 1, rCnt = 1, sCnt = 1, wCnt = 1;

        Random rand = new Random();        
        ArrayList<Hero> result = new ArrayList<>();

        for (int i = 0; i < count; i++){
            int r = rand.nextInt(7) + 1;
            switch (r){
                case 1:
                    result.add(new Crossbower(generateName("Crossbower", cCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "C";
                    cCnt += 1;
                    break;
                case 2:
                    result.add(new Monk(generateName("Monk", mCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "M";
                    mCnt += 1;
                    break;
                case 4:
                    result.add(new Peasant(generateName("Peasant", peCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "p";
                    peCnt += 1;
                    break;
                case 3:
                    result.add(new Pikeman(generateName("Pikeman", piCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "P";
                    piCnt += 1;
                    break;
                case 5:
                    result.add(new Rogue(generateName("Rogue", rCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "R";
                    rCnt += 1;
                    break;
                case 6:
                    result.add(new Sniper(generateName("Sniper", sCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "S";
                    sCnt += 1;
                    break;
                case 7:
                    result.add(new Wizard(generateName("Wizard", wCnt, team), x, i));
                    MyView.MatrixCoordination[i][x-1] = "W";
                    wCnt += 1;
                    break;
            }
        }

        return result;
    }

    private String generateName(String hero, int i, int team) {
        return String.format("%s_%d_%d", hero, team, i);
    }

    public void printTeamsInfo(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        for (Hero hero : team1) {
            Position nearestEnemyPosition = hero.findNearestEnemy(team2);
            System.out.println(String.format("%s. Ближайший враг на позиции (%d, %d)", hero, nearestEnemyPosition.getX(), nearestEnemyPosition.getY()));
        }
        for (Hero hero : team2) {
            Position nearestEnemyPosition = hero.findNearestEnemy(team1);
            System.out.println(String.format("%s. Ближайший враг на позиции (%d, %d)", hero, nearestEnemyPosition.getX(), nearestEnemyPosition.getY()));
        }
    }

    public void battleVikings(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        MyView.fillEmptyBattlefield();
        MyView.drawBattlefield();
        while (team1.size() > 0 && team2.size() > 0) {
            for (Hero hero : team1) {
                if (team2.size() > 0) {
                    System.out.println(hero.step(hero.getPosition(), team2, team1));
                }
            }
            
            for (Hero hero : team2) {
                if (team1.size() > 0) {
                    System.out.println(hero.step(hero.getPosition(), team1, team2));
                }
            }
            MyView.drawBattlefield();
        }

        if (team1.size() > 0) {
            System.out.println("Победила команда Викингов №1");
        } else {
            System.out.println("Победила команда Викингов №2");
        }
    }

    public void battleVikings2(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        while (team1.size() > 0 && team2.size() > 0) {
            View.view();
            for (Hero hero : team1) {
                if (team2.size() > 0) {
                    System.out.println(hero.step(hero.getPosition(), team2, team1));
                }
            }            
            for (Hero hero : team2) {
                if (team1.size() > 0) {
                    System.out.println(hero.step(hero.getPosition(), team1, team2));
                }
            }
        }

        if (team1.size() > 0) {
            System.out.println("Победила команда Викингов №1");
        } else {
            System.out.println("Победила команда Викингов №2");
        }
    }

    public ArrayList<Hero> combineTeams(ArrayList<Hero> team1, ArrayList<Hero> team2) {
        ArrayList<Hero> result = new ArrayList<>();
        result.addAll(team1);
        result.addAll(team2);
        Collections.sort(result);
        return result;
    }
}
