package interfaces;

import java.util.ArrayList;
import common.Position;
import heroes.Hero;

public interface Stepable {
    String step(Position currentPosition, ArrayList<Hero> heroes, ArrayList<Hero> myTeam);
}
