package Sem_5;

import java.util.ArrayList;

public interface Stepable {
    String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam);
}
