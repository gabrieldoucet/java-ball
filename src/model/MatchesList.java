package model;

import helpers.MatchesComparator;
import helpers.ReadFile;
import helpers.TeamsComparator;

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
  }

  public static void withdrawTeam(String teamName) {

  }

  public static void readMatchesScore() {
    // Read teams
    ArrayList<String> scores = ReadFile.readFile("src/data/ResultsIn.txt");
    for (String score : scores) {
      String[] tokens = score.split(" ");
      Team team1 = new Team(tokens[0]);
      Team team2 = new Team(tokens[2]);
      Match existingMatch;
      TeamsComparator tc = new TeamsComparator();
      int res = tc.compare(team1, team2);
      if (res > 0) {
        existingMatch = MatchesList.getMatchFromTeams(team2, team1);
        existingMatch.getScore().setScoreTeam1(Integer.parseInt(tokens[3]));
        existingMatch.getScore().setScoreTeam2(Integer.parseInt(tokens[1]));
      } else {
        existingMatch = MatchesList.getMatchFromTeams(team1, team2);
        existingMatch.getScore().setScoreTeam1(Integer.parseInt(tokens[1]));
        existingMatch.getScore().setScoreTeam2(Integer.parseInt(tokens[3]));
      }
    }
  }

  public static Match getMatchFromTeams(Team team1, Team team2) {
    int indexTeam1 = team1.getIndex();
    int indexTeam2 = team2.getIndex();
    int matchIndex = (indexTeam1 * (2 * TeamsList.getInstance().size() - 2
        - indexTeam1 + 1)) / 2;
    matchIndex += Math.abs(indexTeam2 - indexTeam1 - 1);
    return matchesList.get(matchIndex);
  }
}
