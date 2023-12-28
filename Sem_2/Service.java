package Sem_2;

import java.util.ArrayList;
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
                    cCnt += 1;
                    break;
                case 2:
                    result.add(new Monk(generateName("Monk", mCnt, team), x, i));
                    mCnt += 1;
                    break;
                case 4:
                    result.add(new Peasant(generateName("Peasant", peCnt, team), x, i));
                    peCnt += 1;
                    break;
                case 3:
                    result.add(new Pikeman(generateName("Pikeman", piCnt, team), x, i));
                    piCnt += 1;
                    break;
                case 5:
                    result.add(new Rogue(generateName("Rogue", rCnt, team), x, i));
                    rCnt += 1;
                    break;
                case 6:
                    result.add(new Sniper(generateName("Sniper", sCnt, team), x, i));
                    sCnt += 1;
                    break;
                case 7:
                    result.add(new Wizard(generateName("Wizard", wCnt, team), x, i));
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
            if (hero instanceof Crossbower){
                System.out.println(String.format("%s %s %s", (Crossbower)hero, hero.myPosition(), ((Crossbower)hero).findNearestEnemy(team2)));
            } else {
                System.out.println(hero);
            }
        }
        for (Hero hero : team2) {
            if (hero instanceof Crossbower){
                System.out.println(String.format("%s %s %s", (Crossbower)hero, hero.myPosition(), ((Crossbower)hero).findNearestEnemy(team1)));
            } else {
                System.out.println(hero);
            }
        }
    }
}
