package helpers;

import java.util.Comparator;

import model.Match;

public class MatchesComparator implements Comparator<Match> {
  
  @Override
  public int compare(Match m1, Match m2) {
    
    TeamsComparator tc = new TeamsComparator();
    int firstTeamsCompare = tc.compare(m1.getTeam1(), m2.getTeam1());
    if (firstTeamsCompare == 0) {
      return tc.compare(m1.getTeam2(), m2.getTeam2());
    }
    return firstTeamsCompare;
  }
}
