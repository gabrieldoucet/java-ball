package helpers;

import java.util.Comparator;
import model.Team;

public class TeamsComparator implements Comparator<Team> {

  @Override
  public int compare(Team t1, Team t2) {
    return t1.getName().compareTo(t2.getName());
  }
}
