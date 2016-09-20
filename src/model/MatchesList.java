package model;

import helpers.MatchesComparator;

import java.util.ArrayList;

public class MatchesList extends ArrayList<Match> {
  
  private static final long serialVersionUID = 1L;
  public static MatchesList matchesList = new MatchesList(); 
  
  private MatchesList() {
    super();
  }
  
  public static MatchesList getInstance() {
    return matchesList;
  }
  
  public static void buildMatches() {
    TeamsList teamsList = TeamsList.getInstance();
    Object[] teamsArray = teamsList.toArray();
    for (int i = 0; i < teamsList.size(); i++) {
      for (int j = i + 1; j < teamsList.size(); j++) {
        Match match = new Match((Team) teamsArray[i], (Team) teamsArray[j]);
        matchesList.add(match);
      }
    }
    
    matchesList.sort(new MatchesComparator());
    for (Match match : matchesList) {
      match.printMatch();
    }
  }
  
  public static void withdrawTeam(String teamName) {
    
  }
}
